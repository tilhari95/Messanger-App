package org.suyash.developer.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.suyash.developer.messenger.database.DatabaseClass;
import org.suyash.developer.messenger.model.Message;


public class MessageService {
	
	private Map<Long, Message> messages=DatabaseClass.getMessages();
	
	public MessageService()
	{
		messages.put(1L, new Message(1, "message 1 ", "suyash"));
		messages.put(2L, new Message(2, "message 2 ", "suyash _searing95"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
	 	if(message.getId()<= 0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(long id)
	{
		return messages.remove(id);
	}
	
}



/*private static long count_id=2;

private static final AtomicLong counter = new AtomicLong();
private static List<Message> list;
static{
	System.out.println("run");
	list= populateDummyMessages();
}

public static Map<Long, Message> getMessages()
{
	return messages;
	
}

public static Map<Long, Profile> getProfiles()
{
	return profiles;
}

public List<Message> getAllMesages(){
	
	return list;
	
}

public Message addMessage(Message message)
{
	message.setId(++ count_id);
	list.add(message);
	return message;
	
} 
private static List<Message> populateDummyMessages(){
	list = new ArrayList<Message>();
	Message m1= new Message(1L, "Hello Shashank", "Suyash");
	Message m2= new Message(2L, "Hello Handi", "Suyash");
	
	list.add(m1);
	list.add(m2);
	
	return list;
}
*/
