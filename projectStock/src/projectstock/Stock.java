/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstock;

/**
 *
 * @author vutrunganh
 */
public class Stock {

    private String tradeCode;
    private Double PriceMax, PriceMin;

    static void check() {

        boolean check = true;

        while (!listBuyer.isEmpty() && !listSeller.isEmpty()) {

            Buyer buy = listBuyer.poll();

            Integer soLuong = buy.getQuanlity();

            while (!listSeller.isEmpty()) {

                Seller sale = listSeller.poll();

                if (buy.getPrice() >= sale.getPrice()) {

                    if (soLuong >= sale.getQuanlity()) {

                        soLuong -= sale.getQuanlity();

                        if (soLuong = 0) {
                            break;
                        }

                    } else {

                        Integer soLuongBanConLai = sale.getQuanlity() - soLuong;

                        listSeller.add(new Seller(sale.getId(), sale.getPrice(), soLuongBanConLai));

                        break;

                    }

                } else if (buy.getPrice() < sale.getPrice()) {

                    listSeller.add(sale);

                    if (soLuong > 0) {

                        listBuyer.add(new Buyer(buy.getId(), buy.getPrice(), soLuong));

                    }

                    return;

                }

            }

        }

    }
}
