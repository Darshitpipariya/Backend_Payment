package com.example.backend_payment.DAO;

import com.example.backend_payment.Bean.Bills;

import java.util.List;

public interface BillsDAO {
    boolean addBills(Bills bills);
    // get bill for perticulat student
    List<Bills> getBillList(int stuid);
    List<Bills> getAllBillsList();
    Bills getBill(int billid);
}
