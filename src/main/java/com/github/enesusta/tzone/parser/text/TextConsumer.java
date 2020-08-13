package com.github.enesusta.tzone.parser.text;

import java.util.List;

public interface TextConsumer {
    List<String[]> consumeText(String filename);
}
