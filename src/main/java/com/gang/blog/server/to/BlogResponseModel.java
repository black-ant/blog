package com.gang.blog.server.to;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ResponseTO
 * @Description TODO
 * @Date 2019/12/7 20:00
 * @Created by zengzg
 */
public class BlogResponseModel<E> {

    private String code;

    private E data;

    private String dataType;

    private final Map<String, String> info = new HashMap<>();

    public static <T> BlogResponseModel<T> commonResponse(final T entity) {
        return new BlogResponseModel.Builder<T>().data(entity).info(ResponseType.SUCCESS).dataType(entity == null ? "" :
                entity.getClass().getName()).build();
    }

    public static class Builder<E> {

        protected BlogResponseModel instance;

        protected BlogResponseModel<E> getInstance() {
            if (instance == null) {
                instance = new BlogResponseModel<E>();
            }
            return instance;
        }

        public Builder<E> data(E data) {
            getInstance().setData(data);
            return this;
        }

        public Builder<E> code(String value) {
            getInstance().setCode(value);
            return this;
        }

        public BlogResponseModel<E> build() {
            return getInstance();
        }


        public Builder<E> info(ResponseType responseType) {
            getInstance().getInfo().put("code", responseType.getCode());
            getInstance().getInfo().put("info", responseType.getInfo());
            return this;
        }

        public Builder<E> dataType(String dataType) {
            getInstance().setDataType(dataType);
            return this;
        }

        public Builder<E> info(String key, String value) {
            getInstance().getInfo().put(key, value);
            return this;
        }

    }

    public static enum ResponseType {

        SUCCESS("1", "success"), FAILURE("-1", "failure");

        private String code;
        private String info;

        ResponseType(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}

