package com.bwie.xiaqin.shoppingmu.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/12/12.
 * 圈子
 */

public class QuanBean {

    /**
     * result : [{"commodityId":1,"content":"新圈子","createTime":1544645117000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":30,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-12/8261920181212140517.jpg","nickName":"fh_8iT60","userId":21,"whetherGreat":2},{"commodityId":18,"content":" 好嗨噢，感觉人生已经达到了巅峰，感觉人生已经达到了高潮，好炫彩，好震撼,","createTime":1544644777000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":29,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-12/6521020181212135937.jpg","nickName":"Ronin","userId":63,"whetherGreat":2},{"commodityId":1,"content":"高鑫","createTime":1544644619000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":28,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-12/4716920181212135659.jpg","nickName":"Ronin","userId":63,"whetherGreat":2},{"commodityId":1,"content":"高鑫,最帅","createTime":1544643679000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-12/20181212134404.jpg","id":27,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-12/5812920181212134119.jpg","nickName":"小鼠","userId":18,"whetherGreat":2},{"commodityId":1,"content":"高鑫","createTime":1544643628000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-12/20181212134404.jpg","id":26,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-12/2709320181212134028.jpg","nickName":"小鼠","userId":18,"whetherGreat":2}]
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
         * commodityId : 1
         * content : 新圈子
         * createTime : 1544645117000
         * greatNum : 0
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * id : 30
         * image : http://172.17.8.100/images/small/circle_pic/2018-12-12/8261920181212140517.jpg
         * nickName : fh_8iT60
         * userId : 21
         * whetherGreat : 2
         */

        private int commodityId;
        private String content;
        private String createTime;
        private int greatNum;
        private String headPic;
        private int id;
        private String image;
        private String nickName;
        private int userId;
        private int whetherGreat;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
