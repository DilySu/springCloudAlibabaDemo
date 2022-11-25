package springcloud.service.impl;

import com.dily.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud.mapper.PaymentMapper;
import springcloud.service.PaymentService;

/**
 * Date: 2022-10-27 星期四
 * Time: 14:39
 * Author: Dily_Su
 * Remark:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    public int create(Payment payment) {
        return paymentMapper.insert(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentMapper.selectById(id);
    }
}
