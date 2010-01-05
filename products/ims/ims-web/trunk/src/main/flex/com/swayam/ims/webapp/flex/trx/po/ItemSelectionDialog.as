package com.swayam.ims.webapp.flex.trx.po {

    import  mx.containers.TitleWindow;
    import  mx.controls.Label;
    import  mx.controls.ComboBox;
    import  mx.controls.DateField;
    import  mx.controls.TextInput;
    import  mx.controls.Button;
    import mx.managers.PopUpManager;
    import mx.controls.Alert;
    import mx.events.CloseEvent;
    import flash.events.IEventDispatcher;
    import flash.events.MouseEvent;
    import flash.events.EventDispatcher;
    import flash.events.Event;
    import mx.rpc.remoting.RemoteObject;
    import mx.rpc.events.ResultEvent;
    import mx.rpc.events.FaultEvent;
    import mx.collections.ArrayCollection;
    
    /**
     *  Dispatched when the user selects Item and clicks on the Add button.
     *
     *  @eventType com.swayam.ims.webapp.flex.trx.po.ItemEvent.EVENT_ITEM_ADDED
     *  @tiptext ItemAdded
     */
    [Event(name="ItemAdded", type="com.swayam.ims.webapp.flex.trx.po.ItemEvent")]

    public class ItemSelectionDialog extends TitleWindow {
    	
        [Bindable]
        private var itemsArray:Array = new Array();
        
        private var cbItemList:ComboBox;
    
        public function ItemSelectionDialog() {
        
            initData();
            initComponents();
            
            showCloseButton=true;
            
            layout="absolute";
            
            width = 500;
            height = 450;
            
            addEventListener(CloseEvent.CLOSE, closeWindow);
            
        }
        
        private function initComponents():void {
        
            var lbTitle:Label = new Label();
            lbTitle.text = "Item Search";
            lbTitle.x = 0;
            lbTitle.y = 10;
            /*lbTitle.textAlign="center";
            lbTitle.fontSize=18;
            lbTitle.fontWeight="bold";*/
            addChild(lbTitle);
        
            var lbItemName:Label = new Label();
            lbItemName.text = "Item Name:";
            lbItemName.x = 39;
            lbItemName.y = 60;
            addChild(lbItemName);
            
            cbItemList = new ComboBox();
            cbItemList.x = 140;
            cbItemList.y = 60;
            cbItemList.dataProvider = itemsArray;
            addChild(cbItemList);
            
            //cost price
            var lbItemPrice:Label = new Label();
            lbItemPrice.text = "Price:";
            lbItemPrice.x = 39;
            lbItemPrice.y = 110;
            addChild(lbItemPrice);
            
            var txtPrice:TextInput = new TextInput();
            txtPrice.x = 140;
            txtPrice.y = 110;
            addChild(txtPrice);
            
            //opening stock
            var lbQty:Label = new Label();
            lbQty.text = "Quantity:";
            lbQty.x = 39;
            lbQty.y = 160;
            addChild(lbQty);
            
            var txtQty:TextInput = new TextInput();
            txtQty.x = 140;
            txtQty.y = 160;
            addChild(txtQty);
            
            //batch no.
            var lbBatch:Label = new Label();
            lbBatch.text = "Batch No.:";
            lbBatch.x = 39;
            lbBatch.y = 210;
            addChild(lbBatch);
            
            var txtBatch:TextInput = new TextInput();
            txtBatch.x = 140;
            txtBatch.y = 210;
            addChild(txtBatch);
            
            //maufacture date
            var lbManufactureDate:Label = new Label();
            lbManufactureDate.text = "Manufactured On:";
            lbManufactureDate.x = 39;
            lbManufactureDate.y = 260;
            addChild(lbManufactureDate);
            
            var dtManufactureDate:DateField = new DateField();
            dtManufactureDate.x = 140;
            dtManufactureDate.y = 260;
            addChild(dtManufactureDate);
            
            //expiry date
            var lbExpiryDate:Label = new Label();
            lbExpiryDate.text = "Expiry Date:";
            lbExpiryDate.x = 39;
            lbExpiryDate.y = 310;
            addChild(lbExpiryDate);
            
            var dtExpiryDate:DateField = new DateField();
            dtExpiryDate.x = 140;
            dtExpiryDate.y = 310;
            addChild(dtExpiryDate);
            
            var btCancel:Button = new Button();
            btCancel.label = "Cancel";
            btCancel.x = 103;
            btCancel.y = 360;
            btCancel.addEventListener(MouseEvent.CLICK, closeOnClick);
            addChild(btCancel);
            
            var btAdd:Button = new Button();
            btAdd.label = "Add";
            btAdd.x = 230;
            btAdd.y = 360;
            btAdd.addEventListener(MouseEvent.CLICK, addAndClose);
            addChild(btAdd);
            
        }
        
        private function initData():void {
        
            var itemRO:RemoteObject = new RemoteObject();
            itemRO.destination = "itemDao";
            itemRO.addEventListener("fault", faultHandler);
            itemRO.getAll.addEventListener("result", getListResultHandler);
            itemRO.getAll();
            
        }
            
        private function getListResultHandler(event:ResultEvent):void {

            var itemsMultiArray:ArrayCollection = (ArrayCollection)(event.result);
            var count:int = 0;
            
            for each (var item:Object in itemsMultiArray) {
                var content:Object = new Object();
                content["label"] = item.name;
                content["data"] = item.id;
                itemsArray[count++] = content;
            } 
            
        }
        
        private function faultHandler (event:FaultEvent):void {
         // Deal with event.fault.faultString, etc.
            Alert.show(event.fault.faultString, 'Error');
        }            
        

        private function closeWindow(event:CloseEvent):void {
            close();
        }
        
        private function closeOnClick(event:MouseEvent):void {
            close();
        }
        
        private function addAndClose(event:MouseEvent):void {
        	
        	if (cbItemList.selectedItem != null) {
        		dispatchEvent(new ItemEvent(ItemEvent.EVENT_ITEM_ADDED, cbItemList.selectedItem["data"]));
                close();
        	}
        	
        }
        
        private function close():void {
            PopUpManager.removePopUp(this);
        }
    
    }

}
