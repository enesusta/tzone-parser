package com.github.enesusta.tzone.parser.text;

import java.util.List;

public interface TextConsumer<T> {
    List<T> consumeText(String filename);
}
