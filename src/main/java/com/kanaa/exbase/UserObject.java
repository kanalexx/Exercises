package com.kanaa.exbase;

import com.kanaa.exbase.dataobject.Data;
import com.kanaa.exbase.dataobject.DataObject;
import com.kanaa.exbase.dataobject.Field;
import com.kanaa.exbase.dataobject.FieldType;

@Data(name = "UserObject")
public class UserObject implements DataObject {

    @Field(name = "name", type = FieldType.STRING)
    public String name;

}
