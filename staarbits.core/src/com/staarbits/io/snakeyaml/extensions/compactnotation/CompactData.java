package com.staarbits.io.snakeyaml.extensions.compactnotation;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompactData {
    private String prefix;
    private List<String> arguments = new ArrayList<String>();
    private Map<String, String> properties = new HashMap<String, String>();

    public CompactData(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public List<String> getArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        return "CompactData: " + prefix + " " + properties;
    }
}