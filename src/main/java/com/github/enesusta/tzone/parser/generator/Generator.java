package com.github.enesusta.tzone.parser.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.enesusta.tzone.parser.Parser;

import java.io.IOException;

public abstract class Generator {
    protected final Parser parser = new Parser();
    public abstract void generate() throws IOException;
}
