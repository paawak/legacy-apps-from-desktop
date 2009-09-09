package com.swayam.ims.webapp.flex.trx.po {
	
	import flash.events.Event;
	
	public class ItemEvent extends Event {
		
		public static const EVENT_ITEM_ADDED:String = "ItemAdded";
		
		private var itemId:Object;
		
		public function ItemEvent(eventType:String, itemId:Object) {
			super(eventType);
			this.itemId = itemId;
		}
		
		public function getItemId():Object {
			return itemId;
		}
		
	}
	
}
