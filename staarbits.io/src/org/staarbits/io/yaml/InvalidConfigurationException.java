package org.staarbits.io.yaml;

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

/**
 * Exception thrown when attempting to load an invalid {@link Configuration}
 * @author Bukkit <https://github.com/Bukkit/Bukkit/tree/master/src/main/java/org/bukkit/configuration/InvalidConfigurationException.java>
 */
@SuppressWarnings("serial")
public class InvalidConfigurationException extends Exception {

    /**
     * Creates a new instance of InvalidConfigurationException without a
     * message or cause.
     */
    public InvalidConfigurationException() {}

    /**
     * Constructs an instance of InvalidConfigurationException with the
     * specified message.
     *
     * @param msg The details of the exception.
     */
    public InvalidConfigurationException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of InvalidConfigurationException with the
     * specified cause.
     *
     * @param cause The cause of the exception.
     */
    public InvalidConfigurationException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an instance of InvalidConfigurationException with the
     * specified message and cause.
     *
     * @param cause The cause of the exception.
     * @param msg The details of the exception.
     */
    public InvalidConfigurationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
