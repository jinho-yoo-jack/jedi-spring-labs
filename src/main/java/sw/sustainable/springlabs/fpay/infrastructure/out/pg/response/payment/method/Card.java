package sw.sustainable.springlabs.fpay.infrastructure.out.pg.response.payment.method;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
  "card": {
    "issuerCode": "71",
    "acquirerCode": "71",
    "number": "12345678****000*",
    "installmentPlanMonths": 0,
    "isInterestFree": false,
    "interestPayer": null,
    "approveNo": "00000000",
    "useCardPoint": false,
    "cardType": "신용",
    "ownerType": "개인",
    "acquireStatus": "READY",
    "receiptUrl": "https://dashboard.tosspayments.com/receipt/redirection?transactionId=tviva20240213121757MvuS8&ref=PX",
    "amount": 1000
  },
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
    private String issuerCode;
    private String acquirerCode;
    private String number;
    private String cardType;
    private String acquireStatus;
    private String approveNo;
    private int amount;
    private boolean isInterestFree;
    private String receiptUrl;

}
