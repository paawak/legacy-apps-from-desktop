package com.swayam.ims.webapp.flex.trx.po {

    import  mx.containers.TitleWindow;
    import  mx.controls.Label;
    import  mx.controls.ComboBox;
    import  mx.controls.Button;
    import mx.managers.PopUpManager;
    import mx.controls.Alert;
    import mx.events.CloseEvent;
    import flash.events.MouseEvent;
    import mx.rpc.remoting.RemoteObject;
    import mx.rpc.events.ResultEvent;
    import mx.rpc.events.FaultEvent;
    import mx.collections.ArrayCollection;

    public class ItemSelectionDialog extends TitleWindow {
    
        [Bindable]
        private var itemsArray:Array = new Array();
    
        public function ItemSelectionDialog() {
        
            initData();
            initComponents();
            
            showCloseButton=true;
            
            layout="absolute";
            
            width = 500;
            height = 250;
            
            addEventListener("close", close);
            
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
            lbItemName.text = "ItemName:";
            lbItemName.x = 39;
            lbItemName.y = 75;
            addChild(lbItemName);
            
            var cbItemList:ComboBox = new ComboBox();
            cbItemList.x = 140;
            cbItemList.y = 75;
            cbItemList.dataProvider = itemsArray;
            addChild(cbItemList);
            
            var btCancel:Button = new Button();
            btCancel.label = "Cancel";
            btCancel.x = 103;
            btCancel.y = 214;
            btCancel.addEventListener("click", closeOnClick);
            addChild(btCancel);
            
            var btAdd:Button = new Button();
            btAdd.label = "Add";
            btAdd.x = 230;
            btAdd.y = 214;
            btAdd.addEventListener("click", closeOnClick);
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
        

        private function close(event:CloseEvent):void {
            closeMe();
        }
        
        private function closeOnClick(event:MouseEvent):void {
            closeMe();
        }
        
        private function closeMe():void {
            // Put any clean-up code here.
            PopUpManager.removePopUp(this);
        }
    
    }

}