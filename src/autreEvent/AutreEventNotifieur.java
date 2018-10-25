package autreEvent;

import javax.swing.event.EventListenerList;

public class AutreEventNotifieur {
	private EventListenerList listenerList = new EventListenerList();
	
	public void addAutreEventListener(AutreEventListener listener) {
		this.listenerList.add(AutreEventListener.class, listener);
	}
	
	public void removeAutreEventListener(AutreEventListener listener) {
		this.listenerList.remove(AutreEventListener.class, listener);
	}
	
	public void diffuserAutreEvent (AutreEvent event) {
		Object[] listeners = listenerList.getListenerList();
		for(int i = 0; i < listeners.length; i = i+2) {
			if(listeners[i] == AutreEventListener.class)
				((AutreEventListener)listeners[i+1]).actionADeclancher(event);
		}
	}
}
