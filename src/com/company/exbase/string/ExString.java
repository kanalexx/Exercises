package com.company.exbase.string;

import com.company.exbase.ExBase;

/**
 * @author Alexander Kanunnikov
 */
public interface ExString extends ExBase<String> {

    static ExString create(String value) {
        return new ExStringImpl(value);
    }
}
