package com.team.ecommerce.controller.web;


import com.team.ecommerce.entity.Order;
import com.team.ecommerce.service.OrderService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/api/payment")
public class VNPayController {

    private OrderService orderService;

    @RequestMapping ("/vnpay")
    public String vnpayResult(
            Model model,
            @RequestParam(value = "vnp_Amount") String amount,
            @RequestParam(value = "vnp_TransactionStatus") String transactionStatus,
            @RequestParam(value = "vnp_TxnRef") String idOder,
            @RequestParam(value = "vnp_OrderInfo") String orderInfo
    ) {
        String message = "Thanh toán không thành công";
        Order order = orderService.getOrder(Integer.parseInt(idOder));
        if (transactionStatus.equals("00")){
            order.setStatus(11);
            orderService.saveOrder(order);
            message = "Thanh toán thành công";
        }else {
            message = "LỖI!!! Thanh toán không thành công";
        }

        String finalMessage = message;
        Long totalPrice = Long.valueOf(amount)/100;
        model.addAttribute("message", finalMessage);
        model.addAttribute("idorder", idOder);
        model.addAttribute("orderinfo", orderInfo);
        model.addAttribute("amount", totalPrice);

//        return "redirect:/web/order/"+idOder;
        return "/web/result-payment";
    }



}
