/*
 * $Id: JsonObject.java,v 1.1 2006/04/15 14:10:48 platform Exp $
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A JSON object. Key value pairs are unordered. JsonObject supports java.util.Map interface.
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public class JsonObject extends HashMap implements Map, JsonAware, JsonStreamAware {
	
	private static final long serialVersionUID = -503443796854799292L;
	
	
	public JsonObject() {
		super();
	}

	/**
	 * Allows creation of a JsonObject from a Map. After that, both the
	 * generated JsonObject and the Map can be modified independently.
	 * 
	 * @param map
	 */
	public JsonObject(Map map) {
		super(map);
	}


    /**
     * Encode a map into JSON text and write it to out.
     * If this map is also a JsonAware or JsonStreamAware, JsonAware or JsonStreamAware specific behaviours will be ignored at this top level.
     * 
     * @see JsonValue#writeJSONString(Object, Writer)
     * 
     * @param map
     * @param out
     */
	public static void writeJSONString(Map map, Writer out) throws IOException {
		if(map == null){
			out.write("null");
			return;
		}
		
		boolean first = true;
		Iterator iter=map.entrySet().iterator();
		
        out.write('{');
		while(iter.hasNext()){
            if(first)
                first = false;
            else
                out.write(',');
			Map.Entry entry=(Map.Entry)iter.next();
            out.write('\"');
            out.write(escape(String.valueOf(entry.getKey())));
            out.write('\"');
            out.write(':');
			JsonValue.writeJSONString(entry.getValue(), out);
		}
		out.write('}');
	}

	public void writeJSONString(Writer out) throws IOException{
		writeJSONString(this, out);
	}
	
	/**
	 * Convert a map to JSON text. The result is a JSON object. 
	 * If this map is also a JsonAware, JsonAware specific behaviours will be omitted at this top level.
	 * 
	 * @see JsonValue#toJSONString(Object)
	 * 
	 * @param map
	 * @return JSON text, or "null" if map is null.
	 */
	public static String toJSONString(Map map){
		final StringWriter writer = new StringWriter();
		
		try {
			writeJSONString(map, writer);
			return writer.toString();
		} catch (IOException e) {
			// This should never happen with a StringWriter
			throw new RuntimeException(e);
		}
	}
	
	public String toJSONString(){
		return toJSONString(this);
	}
	
	public String toString(){
		return toJSONString();
	}

	public static String toString(String key,Object value){
        StringBuffer sb = new StringBuffer();
        sb.append('\"');
        if(key == null)
            sb.append("null");
        else
            JsonValue.escape(key, sb);
		sb.append('\"').append(':');
		
		sb.append(JsonValue.toJSONString(value));
		
		return sb.toString();
	}
	
	/**
	 * Escape quotes, \, /, \r, \n, \b, \f, \t and other control characters (U+0000 through U+001F).
	 * It's the same as JsonValue.escape() only for compatibility here.
	 * 
	 * @see JsonValue#escape(String)
	 * 
	 * @param s
	 * @return
	 */
	public static String escape(String s){
		return JsonValue.escape(s);
	}
}
