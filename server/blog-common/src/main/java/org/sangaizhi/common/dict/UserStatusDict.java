package org.sangaizhi.common.dict;

import java.util.Objects;

/**
 * @author sangaizhi
 * @date 2017/9/19
 */
public enum UserStatusDict {

    INIT("INIT", "未激活", (short)0),
    ACTIVATED("ACTIVATED", "已激活", (short)1),
    LOCKED("LOCKED", "锁定", (short)2),
    DISABLED("DISABLED", "禁用", (short)3),
    ;
    private String label;
    private String name;
    private Short value;
    private String errorMsg;

    UserStatusDict(String label, String name, Short value){
        this.label = label;
        this.name = name;
        this.value = value;
    }

    public static boolean contains (String label){
        for (UserStatusDict temp : UserStatusDict.values())
        {
            if (Objects.equals(temp.getLabel(), label))
            {
                return true;
            }
        }
        return false;
    }

    public static String getNameByValue(Short value){
        for (UserStatusDict temp : UserStatusDict.values())
        {
            if (Objects.equals(temp.getValue(), value))
            {
                return temp.getName();
            }
        }
        return null;
    }

    public static Short getValueByName(String name)
    {
        for (UserStatusDict temp : UserStatusDict.values())
        {
            if (Objects.equals(temp.getName(), name))
            {
                return temp.getValue();
            }
        }
        return null;
    }

    public static Short getValueByLabel(String label){
        for (UserStatusDict temp : UserStatusDict.values())
        {
            if (Objects.equals(temp.getLabel(), label))
            {
                return temp.getValue();
            }
        }
        return null;
    }



    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }
}

