# order-receipt-2019-8-22-3-14-40-234
1.无意义的变量名  
desc->description,  
p->price  
qty->quantity  
nm->customerName  
addr->address  
li->ItemList  
  
2.不应该将list集合直接返回，破坏封装   
修改Order中的getLineItems中的方法，使用新变量返回  

3.Order中的变量应该私有化  

4.OrderReceipt中output重复，可以删去多余的output

5.OrderReceipt中的魔法数字应被消除  

6.OrderReceipt中包含长方法，应该抽取出来