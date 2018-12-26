package com.bwie.xiaqin.shoppingmu.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/12/16.
 */

public class CarBean {
    /**
     * result : [{"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg","price":6},{"commodityId":24,"commodityName":"百搭小白鞋 女款 时尚舒适板鞋","count":5,"pic":"http://172.17.8.100/images/small/commodity/nx/bx/7/1.jpg","price":149}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 15
         * commodityName : 玻儿精灵美妆蛋一个
         * count : 3
         * pic : http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg
         * price : 6
         */

        private int commodityId;
        private String commodityName;
        private int count;
        private String pic;
        private int price;
        private boolean isCheck;

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
