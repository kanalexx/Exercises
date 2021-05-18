package com.kanaa.exbase.string;

import com.kanaa.exbase.ExBase;

/**
 * @author Alexander Kanunnikov
 */
public interface ExString extends ExBase<String> {

    static ExString create(String value) {
        return new ExStringImpl(value);
    }
}
