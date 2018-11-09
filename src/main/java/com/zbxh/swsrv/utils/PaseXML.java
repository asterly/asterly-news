package com.zbxh.swsrv.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PaseXML {
	  	
		private List<Book> bookList = null;  
	    private Book book = null;  
	      
	    public List<Book> getBooks(File file){  
	          
	        SAXReader reader = new SAXReader();  
	        try {  
	            Document document = reader.read(file);  
	            Element bookstore = document.getRootElement();  
	            Iterator storeit = bookstore.elementIterator();  
	              
	            bookList = new ArrayList<Book>();  
	            while(storeit.hasNext()){  
	                  
	                book = new Book();  
	                Element bookElement = (Element) storeit.next();  
	                //±È¿˙bookElementµƒ Ù–‘  
	                List<Attribute> attributes = bookElement.attributes();  
	                for(Attribute attribute : attributes){  
	                    if(attribute.getName().equals("id")){  
	                        String id = attribute.getValue();
	                        //System.out.println(id);  
	                        book.setId(Integer.parseInt(id));  
	                    }  
	                }  
	                
	                Iterator bookit = bookElement.elementIterator();
	                
	                while(bookit.hasNext()){  
	                    Element child = (Element) bookit.next();  
	                    String nodeName = child.getName();  
	                    if(nodeName.equals("name")){  
	                        //System.out.println(child.getStringValue());  
	                        String name = child.getStringValue();  
	                        book.setName(name);  
	                    }else if(nodeName.equals("author")){  
	                        String author = child.getStringValue();  
	                        book.setAuthor(author);  
	                    }else if(nodeName.equals("year")){  
	                        String year = child.getStringValue();  
	                        book.setYear(Integer.parseInt(year));  
	                    }else if(nodeName.equals("price")){  
	                        String price = child.getStringValue();  
	                        book.setPrice(Double.parseDouble(price));  
	                    }  
	                }  
	                bookList.add(book);  
	                book = null;  
	                  
	            }  
	        } catch (DocumentException e) {  
	          
	            e.printStackTrace();  
	        }  
	          
	          
	        return bookList;  
	          
	    }
	    

		public static void main(String arge[]) {   
			 InputStream is=PaseXML.class.getClassLoader().getResourceAsStream("querymethod.xml");
			   String url=PaseXML.class.getResource("/querymethod.xml").toString();
			   System.out.println(url);
			 PaseXML px=new PaseXML();
			 px.getBooks(new File(url));
		
		
		}   

}
