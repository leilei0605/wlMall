package com.oaec.wlMall.entity;

public class Cart {
    private Integer c_id;
    private Integer user_id;
    private Integer comm_id;
    private Integer quantity;
    private Integer isdel;
    public Integer getC_id() {
        return c_id;
    }
    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }
    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public Integer getComm_id() {
        return comm_id;
    }
    public void setComm_id(Integer comm_id) {
        this.comm_id = comm_id;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getIsdel() {
        return isdel;
    }
    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
    public Cart(Integer c_id, Integer user_id, Integer comm_id, Integer quantity, Integer isdel) {
        super();
        this.c_id = c_id;
        this.user_id = user_id;
        this.comm_id = comm_id;
        this.quantity = quantity;
        this.isdel = isdel;
    }
    public Cart() {
        super();
    }
    public Cart(Integer c_id, Integer user_id, Integer comm_id, Integer quantity) {
        super();
        this.c_id = c_id;
        this.user_id = user_id;
        this.comm_id = comm_id;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Cart [c_id=" + c_id + ", user_id=" + user_id + ", comm_id=" + comm_id + ", quantity=" + quantity
                + ", isdel=" + isdel + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((c_id == null) ? 0 : c_id.hashCode());
        result = prime * result + ((comm_id == null) ? 0 : comm_id.hashCode());
        result = prime * result + ((isdel == null) ? 0 : isdel.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (c_id == null) {
            if (other.c_id != null)
                return false;
        } else if (!c_id.equals(other.c_id))
            return false;
        if (comm_id == null) {
            if (other.comm_id != null)
                return false;
        } else if (!comm_id.equals(other.comm_id))
            return false;
        if (isdel == null) {
            if (other.isdel != null)
                return false;
        } else if (!isdel.equals(other.isdel))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        if (user_id == null) {
            if (other.user_id != null)
                return false;
        } else if (!user_id.equals(other.user_id))
            return false;
        return true;
    }
}
