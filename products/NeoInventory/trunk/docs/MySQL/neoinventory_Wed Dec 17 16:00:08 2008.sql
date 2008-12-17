-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 17, 2008 at 04:00 PM
-- Server version: 5.0.45
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `neoinventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `bankmaster`
--

CREATE TABLE IF NOT EXISTS `bankmaster` (
  `BankID` varchar(10) NOT NULL,
  `BankName` varchar(30) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`BankID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bankmaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `cashlocmaster`
--

CREATE TABLE IF NOT EXISTS `cashlocmaster` (
  `CL_Ctr` int(11) default NULL,
  `CL_ID` varchar(5) NOT NULL,
  `CL_Name` varchar(5) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`CL_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashlocmaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `co_d`
--

CREATE TABLE IF NOT EXISTS `co_d` (
  `COD_Ctr` int(11) default NULL,
  `CO_No` varchar(10) NOT NULL,
  `SlNo` int(11) NOT NULL,
  `Item_Code` varchar(10) NOT NULL,
  `Qty_Loose` int(11) NOT NULL,
  `SP_Loose` decimal(12,2) NOT NULL,
  `Qty_Pack` int(11) NOT NULL,
  `SP_Pack` decimal(12,2) NOT NULL,
  `Qty_Bulk` int(11) NOT NULL,
  `SP_Bulk` decimal(12,2) NOT NULL,
  `IL_Disc_Perc` varchar(10) NOT NULL,
  `IL_Disc_Amt` decimal(12,2) NOT NULL,
  `IL_Tax_Perc` varchar(10) NOT NULL,
  `IL_Tax_Amt` decimal(12,2) NOT NULL,
  `NetPrice` decimal(12,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `co_d`
--


-- --------------------------------------------------------

--
-- Table structure for table `co_grp`
--

CREATE TABLE IF NOT EXISTS `co_grp` (
  `CO_Grp_Ctr` int(11) default NULL,
  `CO_Grp_ID` varchar(10) NOT NULL,
  `CO_Grp_Name` varchar(30) NOT NULL,
  `Remarks` varchar(30) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`CO_Grp_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `co_grp`
--


-- --------------------------------------------------------

--
-- Table structure for table `co_h`
--

CREATE TABLE IF NOT EXISTS `co_h` (
  `COH_Ctr` int(11) default NULL,
  `CO_GroupID` varchar(10) NOT NULL,
  `Cust_Code` varchar(10) NOT NULL,
  `CO_No` varchar(10) NOT NULL,
  `CO_Date` varchar(10) NOT NULL,
  `CO_Acp_Dt` varchar(10) NOT NULL,
  `AuthBy_ID` varchar(10) NOT NULL,
  `Delivry_By_Dt` varchar(10) NOT NULL,
  `PO_Ref_No` varchar(10) NOT NULL,
  `PO_Ref_Dt` varchar(10) NOT NULL,
  `Terms` varchar(50) NOT NULL,
  `SL_Misc` decimal(12,2) NOT NULL,
  `SL_Disc_Perc` varchar(10) NOT NULL,
  `SL_Disc_Amt` decimal(12,2) NOT NULL,
  `SL_Tax_Perc` varchar(10) NOT NULL,
  `SL_Tax_Amt` decimal(12,2) NOT NULL,
  `GrandTotal` decimal(12,2) NOT NULL,
  `NetTotal` decimal(12,2) NOT NULL,
  `Cancelled` varchar(1) NOT NULL default 'N',
  PRIMARY KEY  (`CO_No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `co_h`
--


-- --------------------------------------------------------

--
-- Table structure for table `currencymaster`
--

CREATE TABLE IF NOT EXISTS `currencymaster` (
  `CM_Ctr` int(11) default NULL,
  `CM_ID` varchar(7) NOT NULL,
  `CM_Name` varchar(30) NOT NULL,
  `CM_BaseCur` decimal(18,2) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`CM_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `currencymaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `custmaster`
--

CREATE TABLE IF NOT EXISTS `custmaster` (
  `CustCtr` int(11) default NULL,
  `CustCode` varchar(6) NOT NULL,
  `CustName` varchar(35) NOT NULL,
  `Street` varchar(20) NOT NULL,
  `Locality` varchar(20) NOT NULL,
  `City` varchar(25) NOT NULL,
  `Pin` varchar(15) NOT NULL,
  `LicenseNo` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `OPhone` varchar(15) NOT NULL,
  `Rphone` varchar(15) NOT NULL,
  `Mobile` varchar(15) NOT NULL,
  `Fax` varchar(15) NOT NULL,
  `Rating` varchar(3) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`CustCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `custmaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `deptmaster`
--

CREATE TABLE IF NOT EXISTS `deptmaster` (
  `DeptCtr` int(11) default NULL,
  `DepID` varchar(10) NOT NULL,
  `DepName` varchar(30) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`DepID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deptmaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `discountmaster`
--

CREATE TABLE IF NOT EXISTS `discountmaster` (
  `DM_Ctr` int(11) default NULL,
  `DM_ID` varchar(10) NOT NULL,
  `DM_Name` varchar(30) NOT NULL,
  `DM_Value` decimal(18,2) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`DM_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `discountmaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `do_d`
--

CREATE TABLE IF NOT EXISTS `do_d` (
  `DOD_Ctr` int(11) default NULL,
  `DO_No` varchar(10) NOT NULL,
  `Item_Sl_No` int(11) NOT NULL,
  `Item_Code` varchar(10) NOT NULL,
  `Batch_No` varchar(10) NOT NULL,
  `Expiry_Date` varchar(12) NOT NULL,
  `Qty_Loose` int(11) NOT NULL,
  `SP_Loose` decimal(18,2) NOT NULL,
  `Qty_Pack` int(11) NOT NULL,
  `SP_Pack` decimal(18,2) NOT NULL,
  `Qty_Bulk` int(11) NOT NULL,
  `SP_Bulk` decimal(18,2) NOT NULL,
  `IL_Disc_ID` varchar(50) NOT NULL,
  `IL_Disc_Amt` decimal(18,2) NOT NULL,
  `IL_Tax_ID` varchar(50) NOT NULL,
  `IL_Tax_Amt` decimal(18,2) NOT NULL,
  `IL_Total_Amt` decimal(18,2) NOT NULL,
  `Modified` char(1) NOT NULL default 'N',
  `Modified_On` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `do_d`
--


-- --------------------------------------------------------

--
-- Table structure for table `do_h`
--

CREATE TABLE IF NOT EXISTS `do_h` (
  `DO_Ctr` int(11) default NULL,
  `DO_No` varchar(50) NOT NULL,
  `DO_Date` varchar(10) NOT NULL,
  `Cust_Code` varchar(10) NOT NULL,
  `Cust_Order_No` varchar(10) NOT NULL,
  `Cust_Order_Date` varchar(10) NOT NULL,
  `PO_Ref_No` varchar(10) NOT NULL,
  `PO_Ref_Date` varchar(10) NOT NULL,
  `Cur_ID` varchar(10) NOT NULL,
  `SL_Disc_ID` varchar(50) NOT NULL,
  `SL_Disc_Amt` decimal(18,2) NOT NULL,
  `SL_Tax_ID` varchar(50) NOT NULL,
  `SL_Tax_Amt` decimal(18,2) NOT NULL,
  `SL_Total_Amt` decimal(18,2) NOT NULL,
  `Store_ID` varchar(10) NOT NULL,
  `Cancelled` char(1) NOT NULL default 'N',
  `Invoiced` char(1) NOT NULL default 'N',
  `Can_Modify` char(1) default 'Y',
  PRIMARY KEY  (`DO_No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `do_h`
--


-- --------------------------------------------------------

--
-- Table structure for table `employeemaster`
--

CREATE TABLE IF NOT EXISTS `employeemaster` (
  `Ctr` int(11) default NULL,
  `EmpCode` varchar(6) NOT NULL,
  `EmpName` varchar(50) NOT NULL,
  `Street` varchar(30) NOT NULL,
  `Locality` varchar(40) NOT NULL,
  `City` varchar(20) NOT NULL,
  `Pin` varchar(10) NOT NULL,
  `DOB` varchar(50) NOT NULL,
  `DOJ` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `RPhone` varchar(15) NOT NULL,
  `Designation` varchar(30) NOT NULL,
  `Department` varchar(30) NOT NULL,
  `Active` varchar(2) NOT NULL,
  PRIMARY KEY  (`EmpCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employeemaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `grn_d`
--

CREATE TABLE IF NOT EXISTS `grn_d` (
  `GRN_Ctr` int(11) default NULL,
  `GRN_No` varchar(10) NOT NULL,
  `Slno` varchar(3) NOT NULL,
  `Item_Code` varchar(10) NOT NULL,
  `Batch_No` varchar(10) NOT NULL,
  `Expiry_Date` varchar(10) NOT NULL,
  `CP_Bulk` decimal(12,2) NOT NULL,
  `CP_Pack` decimal(12,2) NOT NULL,
  `CP_Loose` decimal(12,2) NOT NULL,
  `Curr_ID` varchar(10) NOT NULL,
  `Qty_Bulk` int(11) NOT NULL,
  `Qty_Pack` int(11) NOT NULL,
  `Qty_Loose` int(11) NOT NULL,
  `Free_Qty_Bulk` int(11) NOT NULL,
  `Free_Qty_Pack` int(11) NOT NULL,
  `Free_Qty_Loose` int(11) NOT NULL,
  `Disc_Perc` varchar(10) NOT NULL,
  `Tax_Perc` varchar(10) NOT NULL,
  `SP_Bulk` decimal(12,2) NOT NULL,
  `SP_Pack` decimal(12,2) NOT NULL,
  `SP_Loose` decimal(12,2) NOT NULL,
  `Item_Tot` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grn_d`
--


-- --------------------------------------------------------

--
-- Table structure for table `grn_m`
--

CREATE TABLE IF NOT EXISTS `grn_m` (
  `GRN_Ctr` int(11) default NULL,
  `GRN_No` varchar(9) NOT NULL,
  `GRN_Date` varchar(10) NOT NULL,
  `Store_ID` varchar(10) NOT NULL,
  `Supplier_ID` varchar(10) NOT NULL,
  `AuthBy_ID` varchar(10) NOT NULL,
  `DC_No` varchar(10) NOT NULL,
  `PO_No` varchar(10) NOT NULL,
  `Bill_No` varchar(10) NOT NULL,
  `Bill_Date` varchar(10) NOT NULL,
  `Disc_Percentage` varchar(50) NOT NULL,
  `Tax_Percentage` varchar(50) NOT NULL,
  `Misc_Charges` int(11) NOT NULL,
  `Remarks` varchar(50) NOT NULL,
  `Cancelled` varchar(1) NOT NULL,
  PRIMARY KEY  (`GRN_No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grn_m`
--


-- --------------------------------------------------------

--
-- Table structure for table `invoice_d`
--

CREATE TABLE IF NOT EXISTS `invoice_d` (
  `Inv_D_Ctr` bigint(20) default NULL,
  `Inv_No` varchar(10) NOT NULL,
  `SlNo` smallint(2) NOT NULL,
  `DO_No` varchar(10) NOT NULL,
  `DO_Date` varchar(10) NOT NULL,
  `DO_CurrencyID` varchar(10) NOT NULL,
  `DO_Discount` decimal(12,2) NOT NULL default '0.00',
  `DO_Tax` decimal(12,2) NOT NULL default '0.00',
  `DO_TotalAmount` decimal(12,2) NOT NULL default '0.00'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice_d`
--


-- --------------------------------------------------------

--
-- Table structure for table `invoice_h`
--

CREATE TABLE IF NOT EXISTS `invoice_h` (
  `Inv_H_Ctr` bigint(20) default NULL,
  `Inv_No` varchar(10) NOT NULL,
  `Inv_Date` varchar(10) NOT NULL,
  `Inv_StoreID` varchar(10) NOT NULL,
  `CustName` varchar(50) NOT NULL,
  `KstNo` varchar(30) NOT NULL,
  `CstNo` varchar(30) NOT NULL,
  `InvDCNo` varchar(30) NOT NULL,
  `Inv_CustomerID` varchar(10) NOT NULL,
  `Inv_AuthByID` varchar(10) NOT NULL,
  `TotalDiscount` decimal(12,2) NOT NULL default '0.00',
  `TotalTax` decimal(12,2) NOT NULL default '0.00',
  `TotalAmount` decimal(12,2) NOT NULL default '0.00',
  `Cancelled` char(1) NOT NULL default 'N',
  `Modified` char(1) NOT NULL default 'N',
  `ModifiedOn` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`Inv_No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice_h`
--


-- --------------------------------------------------------

--
-- Table structure for table `item_g`
--

CREATE TABLE IF NOT EXISTS `item_g` (
  `Ctr` int(11) default NULL,
  `itemGroupID` varchar(10) NOT NULL,
  `itemGroupName` varchar(50) NOT NULL,
  `remarks` varchar(50) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`itemGroupID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_g`
--


-- --------------------------------------------------------

--
-- Table structure for table `item_m`
--

CREATE TABLE IF NOT EXISTS `item_m` (
  `itemCtr` int(11) default NULL,
  `itemNo` varchar(10) NOT NULL,
  `itemName` varchar(50) NOT NULL,
  `itemShortName` varchar(10) NOT NULL,
  `itemGroupID` varchar(10) NOT NULL,
  `itemLoosePrice` decimal(12,2) NOT NULL,
  `itemPackPrice` decimal(12,2) NOT NULL,
  `itemBulkPrice` decimal(12,2) NOT NULL,
  `itemLooseperPack` int(11) NOT NULL,
  `itemPackperBulk` int(11) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`itemNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_m`
--


-- --------------------------------------------------------

--
-- Table structure for table `locmaster`
--

CREATE TABLE IF NOT EXISTS `locmaster` (
  `LocCtr` int(11) default NULL,
  `LocID` varchar(6) NOT NULL,
  `LocName` varchar(10) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`LocID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `locmaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `paymodemaster`
--

CREATE TABLE IF NOT EXISTS `paymodemaster` (
  `PayModeCtr` int(11) default NULL,
  `PayModeID` varchar(5) NOT NULL,
  `PayModeName` varchar(5) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`PayModeID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymodemaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `pomaster`
--

CREATE TABLE IF NOT EXISTS `pomaster` (
  `PoNo` varchar(10) NOT NULL,
  `PoDate` varchar(50) NOT NULL,
  `PoGroup` varchar(30) NOT NULL,
  `SupplierCode` varchar(10) NOT NULL,
  `QuotationNo` varchar(10) NOT NULL,
  `QuotationDate` varchar(10) NOT NULL,
  `TaxType` varchar(3) NOT NULL,
  `TaxAmount` decimal(12,2) NOT NULL,
  `DeliverySchedule` varchar(10) NOT NULL,
  `DeliveryPlace` varchar(30) NOT NULL,
  `Terms_Conditions` varchar(50) NOT NULL,
  `AuthorizingPerson` varchar(30) NOT NULL,
  `PkgCharge` decimal(12,2) NOT NULL,
  `MisCharges` varchar(50) NOT NULL,
  `Discount` varchar(5) NOT NULL,
  `TotalQty` int(11) NOT NULL,
  `GrandTotal` decimal(12,2) NOT NULL,
  `DeliveryStatus` varchar(50) NOT NULL,
  `InvoiceStatus` varchar(50) NOT NULL,
  PRIMARY KEY  (`PoNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pomaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchaseorderdetails`
--

CREATE TABLE IF NOT EXISTS `purchaseorderdetails` (
  `POD_Ctr` int(11) default NULL,
  `POM_No` varchar(50) NOT NULL,
  `POD_SerialNo` varchar(10) NOT NULL,
  `Item_ID` varchar(7) NOT NULL,
  `POD_Item_Grp_ID` varchar(7) NOT NULL,
  `POD_UOM_ID` varchar(7) NOT NULL,
  `POD_Item_Loose_Qty` int(11) NOT NULL,
  `POD_Item_Loose_Price` decimal(18,2) NOT NULL,
  `POD_Item_Pack_Qty` int(11) NOT NULL,
  `POD_Item_Pack_Price` decimal(18,2) NOT NULL,
  `POD_Item_Bulk_Qty` int(11) NOT NULL,
  `POD_Item_Bulk_Price` decimal(18,2) NOT NULL,
  `POD_Disc_IL` varchar(50) NOT NULL,
  `POD_Tax_IL` varchar(15) NOT NULL,
  `POD_Net_Loose_Price` decimal(18,2) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchaseorderdetails`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchaseorderhead`
--

CREATE TABLE IF NOT EXISTS `purchaseorderhead` (
  `POM_Ctr` int(11) default NULL,
  `POM_No` varchar(7) NOT NULL,
  `POM_Date` varchar(10) NOT NULL,
  `POM_Str_Id` varchar(50) NOT NULL,
  `POM_Spl_Id` varchar(50) NOT NULL,
  `POM_Dly_Str_Id` varchar(50) NOT NULL,
  `POM_Dly_Date` varchar(50) NOT NULL,
  `POM_PO_Grp_Id` varchar(50) NOT NULL,
  `PO_Cur_Id` varchar(50) NOT NULL,
  `POM_Auth_By_Id` varchar(50) NOT NULL,
  `POM_Cust_RefNo` varchar(50) NOT NULL,
  `POM_Terms` varchar(50) NOT NULL,
  `POM_Misc_Sl` decimal(18,2) NOT NULL,
  `POM_Disc_Sl` varchar(15) NOT NULL,
  `POM_Tax_Sl` varchar(15) NOT NULL,
  `POM_Total_Amt` decimal(18,2) NOT NULL,
  `Cancelled` varchar(1) NOT NULL,
  `Invoiced` char(1) NOT NULL default 'N',
  PRIMARY KEY  (`POM_No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchaseorderhead`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchasereturns_d`
--

CREATE TABLE IF NOT EXISTS `purchasereturns_d` (
  `PR_D_Ctr` int(11) default NULL,
  `PR_No` varchar(10) NOT NULL,
  `Sl_No` smallint(2) NOT NULL,
  `Item_No` varchar(10) NOT NULL,
  `Batch_No` varchar(10) NOT NULL,
  `Expiry_Date` varchar(10) NOT NULL,
  `Currency_ID` varchar(10) NOT NULL,
  `Item_Loose_Qty` int(11) NOT NULL,
  `Item_Loose_Price` decimal(18,2) NOT NULL,
  `Item_Pack_Qty` int(11) NOT NULL,
  `Item_Pack_Price` decimal(18,2) NOT NULL,
  `Item_Bulk_Qty` int(11) NOT NULL,
  `Item_Bulk_Price` decimal(18,2) NOT NULL,
  `Net_Loose_Qty` int(11) NOT NULL default '0',
  `Net_Price` decimal(12,2) NOT NULL default '0.00',
  `Remarks` varchar(100) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchasereturns_d`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchasereturns_h`
--

CREATE TABLE IF NOT EXISTS `purchasereturns_h` (
  `PR_H_Ctr` int(11) default NULL,
  `PR_No` varchar(10) NOT NULL,
  `PR_Date` varchar(10) NOT NULL,
  `GRN_No` varchar(10) NOT NULL,
  `GRN_Date` varchar(10) NOT NULL,
  `DC_No` varchar(10) NOT NULL,
  `PO_No` varchar(10) NOT NULL,
  `Auth_By` varchar(10) NOT NULL,
  `Store_ID` varchar(10) NOT NULL,
  `Supplier_ID` varchar(10) NOT NULL,
  `Total_Loose_Qty_Returned` int(11) NOT NULL default '0',
  `Total_Amt` decimal(12,2) NOT NULL default '0.00',
  `Remarks` varchar(100) default NULL,
  `Cancelled` char(1) NOT NULL default 'N',
  PRIMARY KEY  (`PR_No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchasereturns_h`
--


-- --------------------------------------------------------

--
-- Table structure for table `semaphores`
--

CREATE TABLE IF NOT EXISTS `semaphores` (
  `TableName` varchar(50) NOT NULL,
  `Prefix` varchar(12) NOT NULL default '',
  `Suffix` varchar(12) NOT NULL default '',
  `MaxCtr` int(11) NOT NULL default '1',
  `IDFormat` varchar(12) NOT NULL default '',
  `Remarks` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`TableName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semaphores`
--

INSERT INTO `semaphores` (`TableName`, `Prefix`, `MaxCtr`, `Suffix`, `IDFormat`, `Remarks`) VALUES
('CO_D', '', 1, '', '', ''),
('CO_Grp', '', 1, '', '', ''),
('CO_H', '', 1, '', '', ''),
('DO_D', '', 1, '', '', ''),
('DO_H', '', 1, '', '', ''),
('BankMaster', '', 1, '', '', ''),
('CashLocMaster', '', 1, '', '', ''),
('CurrencyMaster', '', 1, '', '', ''),
('CustMaster', '', 1, '', '', ''),
('DeptMaster', '', 1, '', '', ''),
('DiscountMaster', '', 1, '', '', ''),
('EmployeeMaster', '', 1, '', '', ''),
('GRN_D', '', 1, '', '', ''),
('GRN_M', '', 1, '', '', ''),
('Invoice_D', '', 1, '', '', ''),
('Invoice_H', '', 1, '', '', ''),
('Item_G', '', 1, '', '', ''),
('Item_M', '', 1, '', '', ''),
('LocMaster', '', 1, '', '', ''),
('POMaster', '', 1, '', '', ''),
('PayModeMaster', '', 1, '', '', ''),
('PurchaseOrderDetails', '', 1, '', '', ''),
('PurchaseOrderHead', '', 1, '', '', ''),
('PurchaseReturns_H', '', 1, '', '', ''),
('PurchaseReturns_D', '', 1, '', '', ''),
('StoreMaster', '', 1, '', '', ''),
('SupplierMaster', '', 1, '', '', ''),
('TaxMaster', '', 1, '', '', ''),
('UnitMaster', '', 1, '', '', ''),
('UserMaster', '', 1, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `siteparameters`
--

CREATE TABLE IF NOT EXISTS `siteparameters` (
  `SitePar_Name` varchar(50) NOT NULL,
  `SitePar_TextValue` varchar(125) NOT NULL,
  `SitePar_YesNoValue` varchar(1) NOT NULL,
  `SitePar_LongValue` int(11) NOT NULL,
  `SitePar_DoubleValue` decimal(12,2) NOT NULL,
  `SitePar_ParameterType` int(11) NOT NULL,
  `SitePar_Remarks` varchar(125) NOT NULL,
  PRIMARY KEY  (`SitePar_Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siteparameters`
--


-- --------------------------------------------------------

--
-- Table structure for table `storemaster`
--

CREATE TABLE IF NOT EXISTS `storemaster` (
  `StoreCtr` int(11) default NULL,
  `StoreID` varchar(7) NOT NULL,
  `StoreName` varchar(30) NOT NULL,
  `Remarks` varchar(100) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`StoreID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `storemaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `suppliermaster`
--

CREATE TABLE IF NOT EXISTS `suppliermaster` (
  `SupCtr` int(11) default NULL,
  `SupCode` varchar(10) NOT NULL,
  `supName` varchar(35) NOT NULL,
  `Street` varchar(20) NOT NULL,
  `Locality` varchar(20) NOT NULL,
  `City` varchar(25) NOT NULL,
  `Pin` varchar(15) NOT NULL,
  `LicenseNo` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `OPhone` varchar(15) NOT NULL,
  `Rphone` varchar(15) NOT NULL,
  `Mobile` varchar(15) NOT NULL,
  `Fax` varchar(15) NOT NULL,
  `Rating` varchar(3) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`SupCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppliermaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `taxmaster`
--

CREATE TABLE IF NOT EXISTS `taxmaster` (
  `TaxCtr` int(11) default NULL,
  `TaxCode` varchar(5) NOT NULL,
  `TaxDesc` varchar(50) NOT NULL,
  `Percentage` varchar(5) NOT NULL,
  `Active` varchar(2) NOT NULL,
  PRIMARY KEY  (`TaxCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `taxmaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `unitmaster`
--

CREATE TABLE IF NOT EXISTS `unitmaster` (
  `UnitCtr` int(11) default NULL,
  `UnitID` varchar(7) NOT NULL,
  `UnitName` varchar(50) NOT NULL,
  `Remarks` varchar(100) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`UnitID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unitmaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `usermaster`
--

CREATE TABLE IF NOT EXISTS `usermaster` (
  `UM_Ctr` int(11) default NULL,
  `UM_ID` varchar(5) NOT NULL,
  `UM_Name` varchar(5) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`UM_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usermaster`
--

