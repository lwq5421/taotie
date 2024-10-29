
window.onload=function(){
    this.userid = document.querySelector(".header input").value
    this.list = []
    //绑定类型导航的点击事件
    const searchParams = new URLSearchParams(window.location.search);
    const type = searchParams.get("type")
    let navs = document.querySelectorAll(".nav_item")
    navs.forEach(item =>{
        item.addEventListener("click",()=>{
            queryTypeFood(item.innerHTML)
        })
        if(item.innerHTML == type){
            item.className = item.className + " active"
        }
    })
    //绑定加入订单菜品的事件
    let foods = document.querySelectorAll(".food_item")
    Array.from(foods).map(item =>{
        return {
            id : item.id,
            element : item
        }
    }).forEach(i => {
        i.element.addEventListener("click",()=>{
            if(window.list.indexOf(i.id) < 0 ){
                window.list.push({orderFoodId:i.id})
            }
        })
    })
    // 畅销食品加入订单
    let foods3 = document.querySelectorAll(".food3_item")
    Array.from(foods3).map(item =>{
        return {
            id : item.id,
            element : item
        }
    }).forEach(i => {
        i.element.addEventListener("click",()=>{
            if(window.list.indexOf(i.id) < 0 ){
                window.list.push({orderFoodId:i.id})
            }
        })
    })
    foods3.forEach(item =>{
        item.addEventListener("click",function(event){
            if(event.target.className !== 'add_order3_list'){
                location.href = "http://localhost:8080/taotie_Web_exploded/food?id="+item.id
            }
        })
    })
    //绑定提交订单
    document.querySelector(".commit_order")
        .addEventListener("click",()=>{
            creatOrder()
    })
}

function queryTypeFood(id){
    location.href="http://localhost:8080/taotie_Web_exploded?type="+id
}

async function creatOrder(){
    data = {'customerId' : window.userid,'list' : window.list}
    fetch("http://localhost:8080/taotie_Web_exploded/order/createOrder",{
        method:"post",
        headers:{
            "Content-Type" : "application/json"
        },
        body : JSON.stringify(data)
    }).then(res => {
        return res.json()
    }).then(data => {
        if(data != "null") {
            location.href = "http://localhost:8080/taotie_Web_exploded/order/showOrder/"+data.orderId
        }
    })
}