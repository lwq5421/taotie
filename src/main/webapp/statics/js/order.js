window.onload=function (){
    Array.from(document.querySelectorAll("li")).forEach(ele =>{
        ele.addEventListener("click",()=>{

                let id = ele.querySelector("span:last-child").innerHTML
                location.href = "/taotie_Web_exploded/order/showOrder/"+id

        })
    })
}