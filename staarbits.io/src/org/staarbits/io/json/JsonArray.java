/*
 * $Id: JsonArray.java,v 1.1 2006/04/15 14:10:48 platform Exp $
 * Created on 2006-4-10
 */
package org.staarbits.io.json;

/*
 * Copyright (c) 2019. StaarBits Network & Development says that this file is under the StaarBits Global Copyright (SGC).
 * Every file which contains this annotation as one of the first things written is under the SGC protocol.
 * The SGC (StaarBits Global Copyright) demonstrates that the file which has it cannot be copied and pasted as
 * an annotation file by anyone else who has not gotten the Owner rank at StaarBits. So... The most powerful rank
 * at the executive can spread this file. If someone uses this file without the permission given by the executive
 * administration, this same person will be able to be sued by the SEA (StaarBits Executive Administration); if
 * someone who works at StaarBits spreads this file, this person will as sooner as possible be removed from our
 * team and (s)he will also be able to response a lawsuit as well.
 */

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * A JSON array. JsonObject supports java.util.List interface.
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public class JsonArray extends ArrayList implements JsonAware, JsonStreamAware {
	private static final long serialVersionUID = 3957988303675231981L;
	
	/**
	 * Constructs an empty JsonArray.
	 */
	public JsonArray(){
		super();
	}
	
	/**
	 * Constructs a JsonArray containing the elements of the specified
	 * collection, in the order they are returned by the collection's iterator.
	 * 
	 * @param c the collection whose elements are to be placed into this JsonArray
	 */
	public JsonArray(Collection c){
		super(c);
	}
	
    /**
     * Encode a list into JSON text and write it to out. 
     * If this list is also a JsonStreamAware or a JsonAware, JsonStreamAware and JsonAware specific behaviours will be ignored at this top level.
     * 
     * @see JsonValue#writeJSONString(Object, Writer)
     * 
     * @param collection
     * @param out
     */
	public static void writeJSONString(Collection collection, Writer out) throws IOException
	{
		if(collection == null)
		{
			out.write("The 'collection' must not be equivalent to null");
			return;
		}
		
		boolean first = true;
		Iterator iter=collection.iterator();
		
        out.write('[');
		while(iter.hasNext()){
            if(first)
                first = false;
            else
                out.write(',');
            
			Object value=iter.next();
			if(value == null){
				out.write("null");
				continue;
			}
			
			JsonValue.writeJSONString(value, out);
		}
		out.write(']');
	}
	
	public void writeJSONString(Writer out) throws IOException{
		writeJSONString(this, out);
	}
	
	/**
	 * Convert a list to JSON text. The result is a JSON array. 
	 * If this list is also a JsonAware, JsonAware specific behaviours will be omitted at this top level.
	 * 
	 * @see JsonValue#toJSONString(Object)
	 * 
	 * @param collection
	 * @return JSON text, or "null" if list is null.
	 */
	public static String toJSONString(Collection collection){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(collection, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}

	public static void writeJSONString(byte[] array, Writer out) throws IOException{
		if(array == null){
			out.write("null");
		} else if(array.length == 0) {
			out.write("[]");
		} else {
			out.write("[");
			out.write(String.valueOf(array[0]));
			
			for(int i = 1; i < array.length; i++){
				out.write(",");
				out.write(String.valueOf(array[i]));
			}
			
			out.write("]");
		}
	}
	
	public static String toJSONString(byte[] array){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(array, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public static void writeJSONString(short[] array, Writer out) throws IOException{
		if(array == null){
			out.write("null");
		} else if(array.length == 0) {
			out.write("[]");
		} else {
			out.write("[");
			out.write(String.valueOf(array[0]));
			
			for(int i = 1; i < array.length; i++){
				out.write(",");
				out.write(String.valueOf(array[i]));
			}
			
			out.write("]");
		}
	}
	
	public static String toJSONString(short[] array){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(array, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public static void writeJSONString(int[] array, Writer out) throws IOException{
		if(array == null){
			out.write("null");
		} else if(array.length == 0) {
			out.write("[]");
		} else {
			out.write("[");
			out.write(String.valueOf(array[0]));
			
			for(int i = 1; i < array.length; i++){
				out.write(",");
				out.write(String.valueOf(array[i]));
			}
			
			out.write("]");
		}
	}
	
	public static String toJSONString(int[] array){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(array, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public static void writeJSONString(long[] array, Writer out) throws IOException{
		if(array == null){
			out.write("null");
		} else if(array.length == 0) {
			out.write("[]");
		} else {
			out.write("[");
			out.write(String.valueOf(array[0]));
			
			for(int i = 1; i < array.length; i++){
				out.write(",");
				out.write(String.valueOf(array[i]));
			}
			
			out.write("]");
		}
	}
	
	public static String toJSONString(long[] array){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(array, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public static void writeJSONString(float[] array, Writer out) throws IOException{
		if(array == null){
			out.write("null");
		} else if(array.length == 0) {
			out.write("[]");
		} else {
			out.write("[");
			out.write(String.valueOf(array[0]));
			
			for(int i = 1; i < array.length; i++){
				out.write(",");
				out.write(String.valueOf(array[i]));
			}
			
			out.write("]");
		}
	}
	
	public static String toJSONString(float[] array){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(array, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public static void writeJSONString(double[] array, Writer out) throws IOException{
		if(array == null){
			out.write("null");
		} else if(array.length == 0) {
			out.write("[]");
		} else {
			out.write("[");
			out.write(String.valueOf(array[0]));
			
			for(int i = 1; i < array.length; i++){
				out.write(",");
				out.write(String.valueOf(array[i]));
			}
			
			out.write("]");
		}
	}
	
	public static String toJSONString(double[] array){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(array, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public static void writeJSONString(boolean[] array, Writer out) throws IOException{
		if(array == null){
			out.write("null");
		} else if(array.length == 0) {
			out.write("[]");
		} else {
			out.write("[");
			out.write(String.valueOf(array[0]));
			
			for(int i = 1; i < array.length; i++){
				out.write(",");
				out.write(String.valueOf(array[i]));
			}
			
			out.write("]");
		}
	}
	
	public static String toJSONString(boolean[] array){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(array, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public static void writeJSONString(char[] array, Writer out) throws IOException{
		if(array == null){
			out.write("null");
		} else if(array.length == 0) {
			out.write("[]");
		} else {
			out.write("[\"");
			out.write(String.valueOf(array[0]));
			
			for(int i = 1; i < array.length; i++){
				out.write("\",\"");
				out.write(String.valueOf(array[i]));
			}
			
			out.write("\"]");
		}
	}
	
	public static String toJSONString(char[] array){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(array, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public static void writeJSONString(Object[] array, Writer out) throws IOException{
		if(array == null){
			out.write("null");
		} else if(array.length == 0) {
			out.write("[]");
		} else {
			out.write("[");
			JsonValue.writeJSONString(array[0], out);
			
			for(int i = 1; i < array.length; i++){
				out.write(",");
				JsonValue.writeJSONString(array[i], out);
			}
			
			out.write("]");
		}
	}
	
	public static String toJSONString(Object[] array){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(array, writer);
			return writer.toString();
		} catch(IOException e){
			// This should never happen for a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public String toJSONString(){
		return toJSONString(this);
	}

	/**
	 * Returns a string representation of this array. This is equivalent to
	 * calling {@link JsonArray#toJSONString()}.
	 */
	public String toString() {
		return toJSONString();
	}
}
