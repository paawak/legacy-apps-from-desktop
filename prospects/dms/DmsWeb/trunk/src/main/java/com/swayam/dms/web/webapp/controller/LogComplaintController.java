/*
 * LogComplaintController.java
 *
 * Created on Jun 28, 2008 1:15:03 PM
 *
 * Copyright (c) 2002 - 2008 : Swayam Inc.
 *
 * P R O P R I E T A R Y & C O N F I D E N T I A L
 *
 * The copyright of this document is vested in Swayam Inc. without
 * whose prior written permission its contents must not be published,
 * adapted or reproduced in any form or disclosed or
 * issued to any third party.
 */

package com.swayam.dms.web.webapp.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.swayam.dms.web.dao.GenericDao;
import com.swayam.dms.web.dao.UserDao;
import com.swayam.dms.web.model.Complaint;
import com.swayam.dms.web.model.ComplaintPriority;
import com.swayam.dms.web.model.ComplaintType;
import com.swayam.dms.web.model.Department;
import com.swayam.dms.web.model.User;
import com.swayam.dms.web.model.Ward;

/**
 * 
 * @author paawak
 */
public class LogComplaintController extends BaseFormController {

    private final GenericDao<Complaint, Integer> complaintDao;
    private final GenericDao<Ward, Integer> wardDao;
    private final GenericDao<ComplaintPriority, Integer> priorityDao;
    private final GenericDao<ComplaintType, Integer> complaintTypeDao;
    private final GenericDao<Department, Integer> departmentDao;
    private final UserDao userDao;

    public LogComplaintController(GenericDao<Complaint, Integer> complaintDao,
            GenericDao<Ward, Integer> wardDao,
            GenericDao<ComplaintPriority, Integer> priorityDao,
            GenericDao<ComplaintType, Integer> complaintTypeDao,
            GenericDao<Department, Integer> departmentDao, UserDao userDao) {

        this.complaintDao = complaintDao;
        this.wardDao = wardDao;
        this.priorityDao = priorityDao;
        this.complaintTypeDao = complaintTypeDao;
        this.departmentDao = departmentDao;
        this.userDao = userDao;

        setCommandName("complaint");
        setCommandClass(Complaint.class);

    }

    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) {

        Class<?>[] classes = new Class<?>[] { ComplaintType.class, Ward.class,
                ComplaintPriority.class, Department.class, User.class };

        for (Class<?> clazz : classes) {
            binder.registerCustomEditor(clazz, new LogComplaintEditor(clazz));
        }

        super.initBinder(request, binder);
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request,
            HttpServletResponse response, BindException errors)
            throws Exception {

        ModelAndView view = super.showForm(request, response, errors);

        view.addObject("wardList", wardDao.getAll());
        view.addObject("priorityList", priorityDao.getAll());
        view.addObject("complaintTypeList", complaintTypeDao.getAll());
        view.addObject("departmentList", departmentDao.getAll());

        return view;
    }

    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {
        Complaint complaint = (Complaint) command;
        complaintDao.save(complaint);
        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    @Override
    public ModelAndView processFormSubmission(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        if (request.getParameter("save") == null
                && request.getParameter("department") != null) {

            ModelAndView view = showForm(request, response, errors);

            List<User> usersForDeptList = userDao.getUsers(departmentDao
                    .get(Integer.parseInt(request.getParameter("department"))));

            view.addObject("usersForDeptList", usersForDeptList);

            return view;

        }

        return super.processFormSubmission(request, response, command, errors);
    }

    private class LogComplaintEditor extends PropertyEditorSupport {

        private final Class<?> clazz;

        LogComplaintEditor(Class<?> clazz) {
            this.clazz = clazz;
        }

        @SuppressWarnings("unchecked")
        @Override
        public void setAsText(String text) {

            if (isValueBlank(text, this)) {
                return;
            }

            Integer id = Integer.valueOf(text);

            if (isValueBlank(id, this)) {
                return;
            }

            Object typeForId = getDao().get(id);

            setValue(typeForId);

        }

        private boolean isValueBlank(Object value,
                PropertyEditorSupport propertyEditorSupport) {

            boolean blank = false;

            if (value instanceof String) {

                if (value.equals("")) {
                    blank = true;
                }

            } else if (value instanceof Integer) {

                if ((Integer) value == -1) {
                    blank = true;
                }

            }

            if (blank) {
                propertyEditorSupport.setSource(null);
            }

            return blank;

        }

        @SuppressWarnings("unchecked")
        private GenericDao getDao() {

            GenericDao dao;

            if (clazz == Ward.class) {
                dao = wardDao;
            } else if (clazz == ComplaintPriority.class) {
                dao = priorityDao;
            } else if (clazz == ComplaintType.class) {
                dao = complaintTypeDao;
            } else if (clazz == Department.class) {
                dao = departmentDao;
            } else if (clazz == User.class) {
                dao = userDao;
            } else {

                throw new IllegalArgumentException("Dao for the class "
                        + clazz.getName() + " not found.");
            }

            return dao;

        }
    }

}
