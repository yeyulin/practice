package lock;

import com.Application;
import com.lock.combine.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/13 14:50
 * @since 2.0.7
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Rollback
public class CombineTest {
    @Resource
    private OrderService orderService;

    @Test
    public void testClient() throws IllegalAccessException, InterruptedException {
        Thread thread1 = new Thread(() -> orderService.queryOrderById(1L));
        Thread thread2 = new Thread(() -> orderService.queryOrderById(2L));
        Thread thread3 = new Thread(() -> orderService.queryOrderById(3L));
        Thread thread4 = new Thread(() -> orderService.queryOrderById(4L));
        Thread thread5 = new Thread(() -> orderService.queryOrderById(5L));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        Thread.sleep(100);
        System.out.println("休息一会");
        orderService.queryOrderByIdCombine();


    }
}
