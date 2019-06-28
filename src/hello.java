import com.oaec.wlMall.dao.impl.*;
import com.oaec.wlMall.entity.Commodity;
import com.oaec.wlMall.entity.Type;
import com.oaec.wlMall.service.AddressService;
import com.oaec.wlMall.service.CartService;
import com.oaec.wlMall.service.OrderService;
import com.oaec.wlMall.service.impl.*;

import com.oaec.wlMall.util.CommonDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class hello {
    public static void main(String[] args) {
        /*ComDaoImpl comDao = new ComDaoImpl();
        List<Commodity> mapss = comDao.queryLike("kele");
        for (Commodity maps:mapss
             ) {
            System.out.println("maps"+maps);
        }*/
        String sql = "SELECT * FROM COMMODITY WHERE \"comm_name\" LIKE ?";
        /*new CommonDao().query4BeanList(sql, new CommonDao.EmDao<Commodity>() {
            @Override
            public Commodity getBeanFromResultSet(ResultSet rs) throws SQLException {
                System.out.println(rs.next());
                return null;
            }
        },"kele")

         */
//        LoginServiceImpl loginService = new LoginServiceImpl();
//        Map<String, Object> aa = loginService.login("AA", "123");
//        System.out.println(aa);
//        UserServiceImpl userService = new UserServiceImpl();
//        boolean b = userService.updateUser_name("AA",1);
//        System.out.println(b);
        ;
        CartService cartService = new CartServiceImpl();
//        Map<String, Object> total = cartService.getTotal(1, new String[]{"7"});
//        System.out.println(total);
//        AddressServiceImpl addressService = new AddressServiceImpl();
//        boolean b = addressService.addAddress("1", 123, "215", 1, 0);
//        System.out.println(b);
//        List<Map<String, Object>> maps = addressService.queryByUser_id(1);
//        System.out.println(maps);
//        CartDaoImpl cartDao = new CartDaoImpl();
//        Map<String, Object> map = cartDao.queryByCommAndUserId(1, 5);
//        System.out.println(map);
//        boolean b = cartService.addCart(2, 1, 5);
//        System.out.println(b);
        OrderServiceImpl orderService = new OrderServiceImpl();
//        boolean submit = orderService.submit(1, 1, 100.0, new String[]{"5", "7"});
//        System.out.println(submit);
//        List<Map<String, Object>> orders = orderService.getOrders(1);
//        AddressServiceImpl addressService1 = new AddressServiceImpl();
//        boolean b1 = addressService1.updateIsDefault(1, 1);
//        System.out.println(b1);
//        CartDaoImpl cartDao = new CartDaoImpl();
//        Map<String, Object> commodity = cartDao.queryByCommAndUserId(1, 7);
//        System.out.println(commodity);
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        List<Map<String, Object>> orders = orderService.getOrders(1);
//        OrderDaoImpl orderDao = new OrderDaoImpl();
//        Double totalPrice = orderDao.getTotalPrice(6);
//        System.out.println(totalPrice);
//        CartDaoImpl cartDao = new CartDaoImpl();
//        Map<String, Object> commodity = cartDao.queryByCommAndUserId(1, 5);
//        System.out.println(commodity);
//        OrderService orderService1 = new OrderServiceImpl();
//        boolean submit = orderService1.submit(1, 1,  new String[]{"5", "7"});
//        System.out.println(submit);
        UserServiceImpl userService = new UserServiceImpl();
    }
}
