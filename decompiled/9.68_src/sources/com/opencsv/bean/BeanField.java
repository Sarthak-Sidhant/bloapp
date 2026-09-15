package com.opencsv.bean;

import java.lang.reflect.Field;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BeanField {
    private final Field field;
    private final boolean required;

    public BeanField(Field field, boolean z) {
        this.field = field;
        this.required = z;
    }

    public Field getField() {
        return this.field;
    }

    public boolean isRequired() {
        return this.required;
    }

    public <T> void setFieldValue(T t, String str) throws IllegalAccessException {
        if (this.required && StringUtils.isBlank(str)) {
            throw new IllegalStateException(String.format("Field '%s' is mandatory but no value was provided.", this.field.getName()));
        }
        if (StringUtils.isNotBlank(str)) {
            Class<?> type = this.field.getType();
            this.field.setAccessible(true);
            if (type.equals(Boolean.TYPE)) {
                this.field.setBoolean(t, Boolean.valueOf(str.trim()).booleanValue());
                return;
            }
            if (type.equals(Byte.TYPE)) {
                this.field.setByte(t, Byte.valueOf(str.trim()).byteValue());
                return;
            }
            if (type.equals(Double.TYPE)) {
                this.field.setDouble(t, Double.valueOf(str.trim()).doubleValue());
                return;
            }
            if (type.equals(Float.TYPE)) {
                this.field.setFloat(t, Float.valueOf(str.trim()).floatValue());
                return;
            }
            if (type.equals(Integer.TYPE)) {
                this.field.setInt(t, Integer.parseInt(str.trim()));
                return;
            }
            if (type.equals(Long.TYPE)) {
                this.field.setLong(t, Long.parseLong(str.trim()));
                return;
            }
            if (type.equals(Short.TYPE)) {
                this.field.setShort(t, Short.valueOf(str.trim()).shortValue());
            } else if (type.equals(Character.TYPE)) {
                this.field.setChar(t, str.charAt(0));
            } else {
                if (type.isAssignableFrom(String.class)) {
                    this.field.set(t, str);
                    return;
                }
                throw new IllegalStateException(String.format("Unable to set field value for field '%s' with value '%s' - type is unsupported. Use primitive and String types only.", type, str));
            }
        }
    }
}
