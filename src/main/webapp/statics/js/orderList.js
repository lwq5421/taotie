this.id = document.querySelector("input[type='hidden']").value
this.data = {
    orderId : location.href.split("/").reverse()[0],
    customerId: this.id,
    orderStatus: 1,
    list: [
        {

        }
    ]
}
window.onload = function () {
    // 绑定加减事件
    let list = Array.from(document.querySelectorAll(".subtract,.plus"))
    list.forEach(item => {
        item.addEventListener("click", () => {
            let numberEle = item.parentElement.querySelector(".subtract+span")
            let number = eval(numberEle.innerHTML + item.innerHTML + "1")
            numberEle.innerHTML = number > 1 ? number : 1
            calcTotal()
        })
    })
    //计算总价
    calcTotal()
    //绑定提交事件
    let commitEle = document.querySelector(".btn.commit")
    if(commitEle != undefined){
        commitEle.addEventListener("click", function () {
            caleData()
            fetch("http://localhost:8080/taotie_Web_exploded/order/commitOrder", {
                method: "post",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            }).then(res => {
                return res.json()
            }).then(data => {
                if (data) {
                    location.href = "/taotie_Web_exploded/order/showOrders"  // restful路径
                }
            })
        })
    }
    let settlementEle = document.querySelector(".btn.settlement")
    if(settlementEle != undefined){
        settlementEle.addEventListener("click",()=>{
            fetch("http://localhost:8080/taotie_Web_exploded/order/settlement", {
                method: "post",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({orderId:window.data.orderId})
            }).then(res => {
                return res.json()
            }).then(data => {
                if (data) {
                    location.href = "/taotie_Web_exploded/order/showOrders"  // restful路径
                }
            })
        })
    }
}
function calcTotal() {
    let total = Array.from(document.querySelectorAll(".number"))
        .map(ele => {
            let num = ele.innerHTML / 1
            let price = ele.parentElement.parentElement.querySelector(".price").innerHTML
            return num * price
        })
        .reduce((sum, i) => {
            return sum += i
        })
    document.querySelector("footer>div:first-child>span").innerHTML = total
}
function caleData() {
    this.data.list = Array.from(document.querySelectorAll(".number"))
        .map(ele => {
            let id = ele.id
            let num = ele.innerHTML / 1
            let price = ele.parentElement.parentElement.querySelector(".price").innerHTML
            return {
                orderList:ele.parentElement.parentElement.parentElement.id,
                orderFoodId: ele.id,
                orderNumber: num,
                orderCost: num * price,
                orderListStatus: 2
            }
        })
}











