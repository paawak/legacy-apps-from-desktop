-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 17, 2008 at 02:26 PM
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
-- Table structure for table `BankMaster`
--

CREATE TABLE IF NOT EXISTS `BankMaster` (
  `BankID` varchar(10) NOT NULL,
  `BankName` varchar(30) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`BankID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `BankMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `CashLocMaster`
--

CREATE TABLE IF NOT EXISTS `CashLocMaster` (
  `CL_Ctr` int(11) default NULL,
  `CL_ID` varchar(5) NOT NULL,
  `CL_Name` varchar(5) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`CL_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CashLocMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `CO_D`
--

CREATE TABLE IF NOT EXISTS `CO_D` (
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
-- Dumping data for table `CO_D`
--


-- --------------------------------------------------------

--
-- Table structure for table `CO_Grp`
--

CREATE TABLE IF NOT EXISTS `CO_Grp` (
  `CO_Grp_Ctr` int(11) default NULL,
  `CO_Grp_ID` varchar(10) NOT NULL,
  `CO_Grp_Name` varchar(30) NOT NULL,
  `Remarks` varchar(30) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`CO_Grp_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CO_Grp`
--


-- --------------------------------------------------------

--
-- Table structure for table `CO_H`
--

CREATE TABLE IF NOT EXISTS `CO_H` (
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
-- Dumping data for table `CO_H`
--


-- --------------------------------------------------------

--
-- Table structure for table `CurrencyMaster`
--

CREATE TABLE IF NOT EXISTS `CurrencyMaster` (
  `CM_Ctr` int(11) default NULL,
  `CM_ID` varchar(7) NOT NULL,
  `CM_Name` varchar(30) NOT NULL,
  `CM_BaseCur` decimal(18,2) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`CM_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CurrencyMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `CustMaster`
--

CREATE TABLE IF NOT EXISTS `CustMaster` (
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
-- Dumping data for table `CustMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `DeptMaster`
--

CREATE TABLE IF NOT EXISTS `DeptMaster` (
  `DeptCtr` int(11) default NULL,
  `DepID` varchar(10) NOT NULL,
  `DepName` varchar(30) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`DepID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DeptMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `DiscountMaster`
--

CREATE TABLE IF NOT EXISTS `DiscountMaster` (
  `DM_Ctr` int(11) default NULL,
  `DM_ID` varchar(10) NOT NULL,
  `DM_Name` varchar(30) NOT NULL,
  `DM_Value` decimal(18,2) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`DM_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DiscountMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `DO_D`
--

CREATE TABLE IF NOT EXISTS `DO_D` (
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
-- Dumping data for table `DO_D`
--


-- --------------------------------------------------------

--
-- Table structure for table `DO_H`
--

CREATE TABLE IF NOT EXISTS `DO_H` (
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
-- Dumping data for table `DO_H`
--


-- --------------------------------------------------------

--
-- Table structure for table `EmployeeMaster`
--

CREATE TABLE IF NOT EXISTS `EmployeeMaster` (
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
-- Dumping data for table `EmployeeMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `GRN_D`
--

CREATE TABLE IF NOT EXISTS `GRN_D` (
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
-- Dumping data for table `GRN_D`
--


-- --------------------------------------------------------

--
-- Table structure for table `GRN_M`
--

CREATE TABLE IF NOT EXISTS `GRN_M` (
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
-- Dumping data for table `GRN_M`
--


-- --------------------------------------------------------

--
-- Table structure for table `Invoice_D`
--

CREATE TABLE IF NOT EXISTS `Invoice_D` (
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
-- Dumping data for table `Invoice_D`
--


-- --------------------------------------------------------

--
-- Table structure for table `Invoice_H`
--

CREATE TABLE IF NOT EXISTS `Invoice_H` (
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
-- Dumping data for table `Invoice_H`
--


-- --------------------------------------------------------

--
-- Table structure for table `Item_G`
--

CREATE TABLE IF NOT EXISTS `Item_G` (
  `Ctr` int(11) default NULL,
  `itemGroupID` varchar(10) NOT NULL,
  `itemGroupName` varchar(50) NOT NULL,
  `remarks` varchar(50) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`itemGroupID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Item_G`
--


-- --------------------------------------------------------

--
-- Table structure for table `Item_M`
--

CREATE TABLE IF NOT EXISTS `Item_M` (
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
-- Dumping data for table `Item_M`
--


-- --------------------------------------------------------

--
-- Table structure for table `LocMaster`
--

CREATE TABLE IF NOT EXISTS `LocMaster` (
  `LocCtr` int(11) default NULL,
  `LocID` varchar(6) NOT NULL,
  `LocName` varchar(10) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`LocID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LocMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `PayModeMaster`
--

CREATE TABLE IF NOT EXISTS `PayModeMaster` (
  `PayModeCtr` int(11) default NULL,
  `PayModeID` varchar(5) NOT NULL,
  `PayModeName` varchar(5) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`PayModeID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PayModeMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `POMaster`
--

CREATE TABLE IF NOT EXISTS `POMaster` (
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
-- Dumping data for table `POMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `PurchaseOrderDetails`
--

CREATE TABLE IF NOT EXISTS `PurchaseOrderDetails` (
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
-- Dumping data for table `PurchaseOrderDetails`
--


-- --------------------------------------------------------

--
-- Table structure for table `PurchaseOrderHead`
--

CREATE TABLE IF NOT EXISTS `PurchaseOrderHead` (
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
-- Dumping data for table `PurchaseOrderHead`
--


-- --------------------------------------------------------

--
-- Table structure for table `PurchaseReturns_D`
--

CREATE TABLE IF NOT EXISTS `PurchaseReturns_D` (
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
-- Dumping data for table `PurchaseReturns_D`
--


-- --------------------------------------------------------

--
-- Table structure for table `PurchaseReturns_H`
--

CREATE TABLE IF NOT EXISTS `PurchaseReturns_H` (
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
-- Dumping data for table `PurchaseReturns_H`
--


-- --------------------------------------------------------

--
-- Table structure for table `Semaphores`
--

CREATE TABLE IF NOT EXISTS `Semaphores` (
  `FieldName` varchar(50) NOT NULL,
  `Prefix` varchar(12) NOT NULL default '',
  `MaxCtr` int(11) NOT NULL default '1',
  `Suffix` varchar(12) NOT NULL default '',
  `IDFormat` varchar(12) NOT NULL default '',
  `Remarks` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`FieldName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Semaphores`
--

INSERT INTO `Semaphores` (`FieldName`, `Prefix`, `MaxCtr`, `Suffix`, `IDFormat`, `Remarks`) VALUES
('CO_D \r', '', 1, '', '', ''),
('CO_Grp\r', '', 1, '', '', ''),
('CO_H  \r', '', 1, '', '', ''),
('DO_D  \r', '', 1, '', '', ''),
('DO_H\r', '', 1, '', '', ''),
('BankMaster   \r', '', 1, '', '', ''),
('CashLocMaster  \r', '', 1, '', '', ''),
('CurrencyMaster  \r', '', 1, '', '', ''),
('CustMaster  \r', '', 1, '', '', ''),
('DeptMaster  \r', '', 1, '', '', ''),
('DiscountMaster  \r', '', 1, '', '', ''),
('EmployeeMaster  \r', '', 1, '', '', ''),
('GRN_D  \r', '', 1, '', '', ''),
('GRN_M  \r', '', 1, '', '', ''),
('Invoice_D \r', '', 1, '', '', ''),
('Invoice_H\r', '', 1, '', '', ''),
('Item_G \r', '', 1, '', '', ''),
('Item_M \r', '', 1, '', '', ''),
('LocMaster \r', '', 1, '', '', ''),
('POMaster  \r', '', 1, '', '', ''),
('PayModeMaster   \r', '', 1, '', '', ''),
('PurchaseOrderDetails    \r', '', 1, '', '', ''),
('PurchaseOrderHead  \r', '', 1, '', '', ''),
('PurchaseReturns_H\r', '', 1, '', '', ''),
('PurchaseReturns_D \r', '', 1, '', '', ''),
('StoreMaster\r', '', 1, '', '', ''),
('SupplierMaster \r', '', 1, '', '', ''),
('TaxMaster   \r', '', 1, '', '', ''),
('UnitMaster \r', '', 1, '', '', ''),
('UserMaster   ', '', 1, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `SiteParameters`
--

CREATE TABLE IF NOT EXISTS `SiteParameters` (
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
-- Dumping data for table `SiteParameters`
--


-- --------------------------------------------------------

--
-- Table structure for table `StoreMaster`
--

CREATE TABLE IF NOT EXISTS `StoreMaster` (
  `StoreCtr` int(11) default NULL,
  `StoreID` varchar(7) NOT NULL,
  `StoreName` varchar(30) NOT NULL,
  `Remarks` varchar(100) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`StoreID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StoreMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `SupplierMaster`
--

CREATE TABLE IF NOT EXISTS `SupplierMaster` (
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
-- Dumping data for table `SupplierMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `TaxMaster`
--

CREATE TABLE IF NOT EXISTS `TaxMaster` (
  `TaxCtr` int(11) default NULL,
  `TaxCode` varchar(5) NOT NULL,
  `TaxDesc` varchar(50) NOT NULL,
  `Percentage` varchar(5) NOT NULL,
  `Active` varchar(2) NOT NULL,
  PRIMARY KEY  (`TaxCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TaxMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `UnitMaster`
--

CREATE TABLE IF NOT EXISTS `UnitMaster` (
  `UnitCtr` int(11) default NULL,
  `UnitID` varchar(7) NOT NULL,
  `UnitName` varchar(50) NOT NULL,
  `Remarks` varchar(100) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`UnitID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `UnitMaster`
--


-- --------------------------------------------------------

--
-- Table structure for table `UserMaster`
--

CREATE TABLE IF NOT EXISTS `UserMaster` (
  `UM_Ctr` int(11) default NULL,
  `UM_ID` varchar(5) NOT NULL,
  `UM_Name` varchar(5) NOT NULL,
  `Active` varchar(1) NOT NULL,
  PRIMARY KEY  (`UM_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `UserMaster`
--

