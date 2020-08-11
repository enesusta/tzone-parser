package com.github.enesusta.tzone.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;

public abstract class Consumer {
    protected final Parser parser = new Parser();
    protected final ObjectMapper objectMapper = new ObjectMapper();
    protected abstract void consume() throws IOException;
}
