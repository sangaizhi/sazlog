package org.sangaizhi.common.dict;

import java.util.Objects;

/**
 * 评论主题类型字典
 * @author sangaizhi
 * @date 2017/9/26
 */
public enum  CommentTopicDict {


    ARTICLE("ARTICLE", "文章", (short)0),
    COMMENT("COMMENT", "评论", (short)1),
    SITE("SITE", "站点", (short)2),
    TOOL("TOOL", "工具", (short)3),
    ;
    private String label;
    private String name;
    private Short value;

    CommentTopicDict(String label, String name, Short value){
        this.label = label;
        this.name = name;
        this.value = value;
    }

    public static boolean contains (String label){
        for (CommentTopicDict temp : CommentTopicDict.values())
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
