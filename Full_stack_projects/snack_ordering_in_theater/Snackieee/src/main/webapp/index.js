function getTicketId(){
	document.getElementById("navbar").style.display="none";
	document.getElementById("order-details-heading").style.display="none";
	
	var ticket = document.getElementById("ticketid");
	
	ticket.innerHTML = "";
	
	let show = `<div class="d-flex flex-column justify-content-center align-items-center p-3" >
        <label for="exampleFormControlInput1" class="text-dark p-3">Enter
          Ticket Id</label> 
          <input type="text" class="form-control"
          name="ticketid" id="tid" placeholder="ticket id" />
        <p class="btn btn-secondary mt-3" onclick="validateticketid()">Submit</p>
      </div>`;
	ticket.innerHTML = show;
}

function validateticketid(){
	debugger;
	var ticketid = document.getElementById("tid").value;
	if(ticketid == "" || ticketid == null){
		launch_toast("Enter ticket id", false);
		getTicketId();
	}
	else{
		viewCategories();
	}
}

function viewCategories() {
	document.getElementById("ticketid").style.display = "none";
	document.getElementById("navbar").style.display="block";
	document.getElementById("empty-cart").innerHTML = "";
	document.getElementById("cart-heading").style.display = "none";
	document.getElementById("order-details-heading").style.display = "none";
	document.getElementById("order-details-body").innerHTML = "";
	document.getElementById("checkout").style.display = "none";
	document.getElementById("payment-confirm").style.display = "none";
	document.getElementById("carouselExampleIndicators").style.display = "block";
	document.getElementById("cart-body").innerHTML = "";
	document.getElementById("empty-orders").innerHTML = "";
	document.getElementById("orderhistory").innerHTML = "";
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res != null) {

				var searchResult = document.getElementById("items");

				searchResult.innerHTML = "";

				for (let i = 0; i < res.length; i++) {

					let cat = `
					<div class="card border-0 m-3" style="width: 18rem; height: 22rem;">
				        <img src="categories/${res[i].categoryimage}" class="card-img-top" alt="${res[i].categoryname}" height="165rem" width="50px">
				        <div class="card-body">
				          <h5 class="card-title">${res[i].categoryname}</h5>
				          <p class="card-text">${res[i].categorydesc}</p>
				          <button onclick="viewSnacks(${res[i].categoryid})" class="btn btn-dark"  value="${res[i].categoryid}">Show Snacks</button>
		        		</div>
		      		</div>`;
					searchResult.innerHTML += (cat);
				}

			} else {
				launch_toast("No categories found", false);
				return;
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/getcategories");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	
	xhr.send();
}

function viewSnacks(catId) {

	document.getElementById("carouselExampleIndicators").style.display = "none";

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res != null) {
				showSnacks(res);
			} else {
				launch_toast("No snacks exists under this category", false);
				return;
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/getsnacks");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("catid=" + catId);
}

function showSnacks(res) {
	var searchResult = document.getElementById("items");

	searchResult.innerHTML = "";

	for (let i = 0; i < res.length; i++) {

		let cat = `<div class="card border-0 m-3 mt-3" style="width: 18rem; height: 28rem;">
		          <img src="${res[i].snackimage}" class="card-img-top" alt="${res[i].snackname}" height="165rem" width="50px">
		          <div class="card-body">
		          <h5 class="card-title">${res[i].snackname}</h5>
		          <p onclick="showreview(${res[i].snackid})" class="text-danger" style="cursor: pointer;">show reviews</p>
		          <p >Price : ${res[i].snackprice}</p>
		          <p >Stock : ${res[i].snackstock}</p>
		          <p >Quantity : ${res[i].snackquantity}</p>
		          <div class="d-flex justify-content-between align-items-center">
            		<div class="btn btn-dark h-25" onclick="addtocart(${res[i].snackid})">Add to cart</div>
            		<input type="number" name="cartcount" id="${res[i].snackid}" min=1 style="width:50px;">
          		  </div>
		        </div>
		      </div>`;

		searchResult.innerHTML += (cat);
	}
}

function searchsnacks() {
	document.getElementById("cart-heading").style.display = "none";
	document.getElementById("order-details-heading").style.display = "none";
	document.getElementById("order-details-body").innerHTML = "";
	document.getElementById("checkout").style.display = "none";
	document.getElementById("payment-confirm").style.display = "none";
	document.getElementById("cart-body").innerHTML = "";
	document.getElementById("empty-orders").innerHTML = "";
	document.getElementById("orderhistory").innerHTML = "";
	document.getElementById("empty-cart").innerHTML = "";
	var searchkeyword = document.getElementById("snacksearch").value.trim();

	if (searchkeyword == null)
		return;
		
	if (searchkeyword == "_"){
		launch_toast("No such product exists", false);
		return;
	}

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res != null) {	
				document.getElementById("carouselExampleIndicators").style.display = "none";
				showSnacks(res);
			} else {
				launch_toast("No such product exists", false);
				return;
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/searchsnack");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("searchkeyword=" + searchkeyword);
}

function showreview(snackid) {
	var xhr = new XMLHttpRequest();
	var body = document.getElementById("showreviewmodalbody");

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res != null) {
				showreviewvisible();
				for (let i = 0; i < res.length; i++) {
					let cat = `<p class="mt-3 p-3">${res[i].review}</p><hr>`
					body.innerHTML += cat;
				}
			} else {
				launch_toast("No reviews added yet", false);
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/showreview");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("snackid=" + snackid);

}

function addtocart(snackid) {
	var itemcount = Number(document.getElementById(snackid).value);
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res == false) {
				launch_toast("Invalid Count", false);
			}
			else if (res == -1) {
				launch_toast("Login before add to cart", false);
			}
			else {
				launch_toast("Items added to the cart successfully", true);
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/addtocart");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("itemcount=" + itemcount + "&snackid=" + snackid);

}

function viewCart() {
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res == -1) {
				launch_toast("Login to view cart", false);
				viewCategories();
			}
			else if (res != null) {
				showcart(res);
			} else {
				showemptycart();
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/viewcart");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send();
}

function showcart(res) {
	var totalamount = 0;
	var totaltax = 0;
	document.getElementById("carouselExampleIndicators").style.display = "none";
	document.getElementById("items").innerHTML = "";
	document.getElementById("empty-cart").innerHTML = "";
	document.getElementById("empty-orders").innerHTML = "";
	document.getElementById("cart-heading").style.display = "block";
	document.getElementById("checkout").style.display = "block";
	document.getElementById("cart-body").style.display = "block";
	document.getElementById("payment-confirm").style.display = "none";
	document.getElementById("orderhistory").innerHTML = "";
	document.getElementById("order-details-heading").style.display = "none";
	document.getElementById("order-details-body").innerHTML = "";

	var cart = document.getElementById("cart-body");

	cart.innerHTML = "";

	for (let i = 0; i < res.length; i++) {

		let cat = `
		<tr class="d-flex container-fluid justify-content-between align-items-center border-bottom me-4" style="width:80vw">
          <td><p>${res[i].snackname}</p><p>Rs . ${res[i].snackprice}</p>
          <p class="btn" onclick="removecartitem(${res[i].snack_id})"><svg style="color: red;" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
            <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
          </svg></p>
          </td>
          <td>${res[i].snackquantity} nos</td>
          <td>Rs . ${res[i].snacktotalprice}</td>
        </tr>`;

		cart.innerHTML += (cat);

		totalamount += res[i].snacktotalprice;
		totaltax += res[i].snack_tax;
	}

	let mass_total = totalamount + totaltax;
	let cat1 = `
		<tr class="d-flex container-fluid justify-content-between align-items-center me-4" style="width:80vw">
          <td></td>
          <td>Sub Total</td>
          <td id="basicamounttopay">Rs.${totalamount}</td>
        </tr>
        <tr class="d-flex container-fluid justify-content-between align-items-center me-4" style="width:80vw">
          <td></td>
          <td>Tax</td>
          <td id="taxtopay">Rs.${totaltax}</td>
        </tr>
        <tr class="d-flex container-fluid justify-content-between align-items-center me-4" style="width:80vw">
          <td></td>
          <td>Total</td>
          <td id="amounttopay">Rs.${mass_total}</td>
        </tr>
        <div class="container d-flex align-items-center justify-content-end">
	      <div class="me-3">Enter row no : </div>
	      <div><input type="text" id="rowno" required/></div>
	    </div>
	    <div class="mt-3  container d-flex align-items-center justify-content-end">
	      <div class="me-3">Enter seat no : </div>
	      <div><input type="number" id="seatno" required/></div>
	    </div>`;

	cart.innerHTML += (cat1);
	document.getElementById("checkout").style.display = "flex";
	document.getElementById("checkout").classList.add("flex-row");
}

function removecartitem(snackid) {
	document.getElementById("empty-cart").innerHTML = "";
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res)
				viewCart();
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/removecartitem");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("snackid=" + snackid);
}

function showemptycart() {
	document.getElementById("carouselExampleIndicators").style.display = "none";
	document.getElementById("items").innerHTML = "";
	document.getElementById("cart-body").innerHTML = "";
	document.getElementById("empty-orders").innerHTML = "";
	document.getElementById("cart-heading").style.display = "none";
	document.getElementById("checkout").style.display = "none";
	document.getElementById("payment-confirm").style.display = "none";
	document.getElementById("order-details-heading").style.display = "none";
	document.getElementById("order-details-body").innerHTML = "";
	var show = document.getElementById("empty-cart");
	show.innerHTML = "";
	let cat = `<img src="shopping-cart.gif" />
			<div style="font-size: 5vw;">no items in the cart</div>`;
	show.innerHTML += cat;
}

function getOrderDetails(orderid) {
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			showOrderDetails(res);
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/viewOrderDetails");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("orderid=" + orderid);
}

function showOrderDetails(res) {
	document.getElementById("carouselExampleIndicators").style.display = "none";
	document.getElementById("items").innerHTML = "";
	document.getElementById("empty-cart").innerHTML = "";
	document.getElementById("empty-orders").innerHTML = "";
	document.getElementById("cart-heading").style.display = "none";
	document.getElementById("checkout").style.display = "none";
	document.getElementById("cart-body").style.display = "none";
	document.getElementById("payment-confirm").style.display = "none";
	document.getElementById("orderhistory").innerHTML = "";
	document.getElementById("order-details-heading").style.display = "none";
	document.getElementById("order-details-body").innerHTML = "";
	document.getElementById("order-details-heading").style.display = "block";
	document.getElementById("order-details-body").innerHTML = "";

	var cart = document.getElementById("order-details-body");

	cart.innerHTML = "";

	for (let i = 0; i < res.length; i++) {

		let cat = `
		<tr class="d-flex container-fluid justify-content-between align-items-center border-bottom me-4" style="width:80vw">
          <td><p>${res[i].snack_name}</p><p>Rs . ${res[i].snack_amount}</p>
          </td>
          <td>${res[i].snack_count} nos</td>
          <td><div class="btn btn-secondary" onclick="showreviewmodal(${res[i].snack_id})">Add Review</div></td>
        </tr>`;
		cart.innerHTML += (cat);
	}

}

function showreviewmodal(snack_id) {
	document.getElementById("reviewmodal").innerHTML = "";
	reviewvisible();
	document.getElementById("reviewmodal").innerHTML += `
		<div class="modal-content container" style="width: 35vw;">
			<div class="modal-header">
				<h2 class="fs-5 text-wrap text-center">Give Review</h2>
				<span class="close" onclick="reviewHide()">&times;</span>
			</div>
			<div class="modal-body">
				<div class="mb-4">
					<label for="exampleFormControlInput2" class="form-label">Enter
						your review for this product</label> 
					<textarea name="review" id="snackreview" cols="30" rows="10"></textarea>
				</div>
				<div class="text-center">
					<button onclick="addreview(${snack_id})" class="btn btn-dark">ADD REVIEW</button>
				</div>
			</div>
		</div>
	`;
}

function addreview(snack_id) {
	var review = document.getElementById("snackreview").value;
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res == true) {
				reviewHide();
				launch_toast("Reviews added successfully", true);
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/addReview");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("snack_id=" + snack_id + "&review=" + review);
}

function checkout() {
	document.getElementById("cart-heading").style.display = "none";
	document.getElementById("checkout").style.display = "none";
	document.getElementById("cart-body").style.display = "none";
	var amounttopay = document.getElementById("amounttopay").innerHTML;
	var taxtopay = document.getElementById("taxtopay").innerHTML;
	var basicamounttopay = document.getElementById("basicamounttopay").innerHTML;
	document.getElementById("payment-info").style.display = "block";
	var show = document.getElementById("inner-payment");
	show.innerHTML = "";

	let payment = `
			<div class="border p-3 mt-3" style="width: 40vw;">
				<div class="d-flex bg-gray border-0 align-items-center justify-content-start">
					<span class="ps-3"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
							class="bi bi-info-circle text-dark ms-1 mb-1" viewBox="0 0 16 16">
		              <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
		              <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z" />
		              </svg>
	             	</span>
					<div class="ms-3">Verify the information before proceeding</div>
				</div>
				<div class="mt-3 d-flex align-items-center justify-content-between">
					<p>Sub Total</p>
					<p><b>${basicamounttopay}</b></p>
				</div>
				<div class="mt-3 d-flex align-items-center justify-content-between">
					<p>Tax</p>
					<p><b>${taxtopay}</b></p>
				</div>
				<hr>
				<div class="mt-3 d-flex align-items-center justify-content-between">
					<p>Total</p>
					<p><b>${amounttopay}</b></p>
				</div>
			</div>
			<div class="container mt-3 border p-s d-flex" style="width: 40vw;">
				<span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
						class="bi bi-credit-card text-dark ms-1 mb-1" viewBox="0 0 16 16">
		            <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4zm2-1a1 1 0 0 0-1 1v1h14V4a1 1 0 0 0-1-1H2zm13 4H1v5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V7z" />
		            <path d="M2 10a1 1 0 0 1 1-1h1a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1v-1z" /></svg>
	            </span>
	            <input type="text" id="upi id" placeholder="Enter UPI ID" class="ms-3 border-0 ps-3" style="width: 40vw;" />
			</div>
			<div>
				<p class="mt-3">Try Another methods</p>
				<div class="d-flex">
					<div class="me-3">
						<a href="https://pay.google.com/gp/w/home/signup?sctid=5558846980776615">
							<img class="icon border rounded-circle" style="width: 55px; height: 55px;" src="google-pay.png" />
						</a>
					</div>
					<div class="ms-3">
						<a href="https://paytm.com/">
							<img class="icon border rounded-circle" style="width: 55px; height: 55px;" src="paytm.png" />
						</a>
					</div>
				</div>
				<p class="qrcode text-decoration-underline mt-3" onclick="openqrcode()">To scan click here ..</p>
			</div>
			<div>
			<div>
          <div class="mt-3 btn btn-success" onclick="paymentconfirm()">Pay and procced >></div>
        </div>`;

	show.innerHTML += payment;

}

function openqrcode() {
	document.getElementById("payment-info").style.display = "none";
	document.getElementById("inner-payment").style.display = "none";
	var show = document.getElementById("qrcode");
	let qr = `
		<div class="d-flex flex-column justify-content-center align-items-center" style="margin-top: 10%;">
	        <img src="gpay_qr.jpeg" style="width: 200px; height: 200pxh;">
	        <div class="qrcode mt-3" onclick="paymentconfirm()">click here to confirm order (skip) ...</div>
      	</div>`;
	show.innerHTML += qr;
}

function paymentconfirm() {
	document.getElementById("payment-info").style.display = "none";
	document.getElementById("inner-payment").style.display = "none";
	document.getElementById("qrcode").style.display = "none";
	var rowno = document.getElementById("rowno").value;
	var seatno = document.getElementById("seatno").value;
	var amounttopay = document.getElementById("amounttopay").innerHTML;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res == true) {
				document.getElementById("payment-confirm").style.display = "block";
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/confirmorder");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("rowno=" + rowno + "&seatno=" + seatno + "&amounttopay=" + amounttopay);
}

function showorderhistory() {
	document.getElementById("carouselExampleIndicators").style.display = "none";
	document.getElementById("items").innerHTML = "";
	document.getElementById("empty-cart").innerHTML = "";
	document.getElementById("cart-heading").style.display = "none";
	document.getElementById("checkout").style.display = "none";
	document.getElementById("cart-body").style.display = "none";
	document.getElementById("payment-confirm").style.display = "none";
	document.getElementById("order-details-heading").style.display = "none";
	document.getElementById("order-details-body").innerHTML = "";

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let resp = xhr.responseText;
			console.log(resp);
			let res = JSON.parse(resp);
			if (res == -1) {
				launch_toast("Login to view your orders", false);
				viewCategories();
			}
			else if (res != null) {
				showhistory(res);
			} else {
				showemptyhistory();
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/gethistory");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send();
}

function showhistory(res) {
	var his = document.getElementById("orderhistory");

	his.innerHTML = "";

	for (let i = 0; i < res.length; i++) {

		let cat = `
		<div class="mt-3 border-bottom pb-3">
		  <div class="d-flex justify-content-between align-items-center">
	        <div><b>Order id : ${res[i].order_id}</b></div>
	        <div><b>${res[i].amount_paid}</b></div>
	      </div>
	      <div class="d-flex justify-content-between align-items-center">
	        <div>${res[i].ordered_date}</div>
	        <div><img src="check.png" alt="" style="width: 20px;height: 20px;"></div>
	      </div>
	      <div class="d-flex justify-content-end mt-3">
	        <div class=" btn btn-secondary" onclick="getOrderDetails(${res[i].order_id})">show details</div>
	      </div>
	      </div>`;

		his.innerHTML += (cat);
	}
}

function showemptyhistory() {
	document.getElementById("carouselExampleIndicators").style.display = "none";
	document.getElementById("items").innerHTML = "";
	document.getElementById("cart-body").innerHTML = "";
	document.getElementById("cart-heading").style.display = "none";
	document.getElementById("checkout").style.display = "none";
	document.getElementById("payment-confirm").style.display = "none";
	document.getElementById("order-details-heading").style.display = "none";
	document.getElementById("order-details-body").innerHTML = "";
	var show = document.getElementById("empty-orders");
	show.innerHTML = "";
	let cat = `<img src="out-of-stock.png" />
			<div style="font-size: 5vw;">you didn't ordered any items yet</div>`;
	show.innerHTML += cat;
}

function verifyPassword() {
	var password1 = document.getElementById("regpassword1").value;
	var password2 = document.getElementById("regpassword2").value;
	if (password1.trim() != password2.trim()) {
		document.getElementById("regerror").innerHTML = "Password doesn't match";
	}
	else {
		createaccount();
	}
}

function createaccount() {
	var username = document.getElementById("regusername").value;
	var mailid = document.getElementById("regmailid").value;
	var password = document.getElementById("regpassword1").value;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res == true) {
				document.getElementById("regerror").innerHTML = "Mail Id already exists";
			}
			else if (res == false) {
				registerHide();
				launch_toast("Account created successfully", true);
			}
			else if (res == -1) {
				registerHide();
				launch_toast("Logout before creating account", false);
			}
			else if (res == -2) {
				registerHide();
				launch_toast("Invalid Username", false);
			}
			else if (res == -3) {
				registerHide();
				launch_toast("Invalid Password", false);
			}
			else if (res == -4) {
				registerHide();
				launch_toast("Password shouldn't contains space", false);
			}
			else if (res == -5) {
				registerHide();
				launch_toast("Invalid mail id", false);
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/createuser");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("username=" + username + "&mailid=" + mailid + "&password=" + password);
}

function loginvalidate() {

	let promise = new Promise(
		function(resolve, reject) {
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					resolve(xhr.responseText);
				}
			}
			xhr.open("POST", "http://localhost:8081/Snackieee/loginvalidate");
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send();
		}
	);
	return promise;

}

function userLogin() {

	loginvalidate().then(function(result) {
		var res = JSON.parse(result);
		if (res == -1) {
			registerHide();
			launch_toast("Log Out and Try again", false);
		}
		else {
			loginvisible();
		}
	});
}

function login() {
	var mailid = document.getElementById("loginmailid").value;
	var password = document.getElementById("loginpassword").value;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res == true) {
				loginHide();
				launch_toast("Logined successfully", true);
			} else if (res == -2) {
				registerHide();
				launch_toast("Invalid password", false);
			}
			else if (res == -3) {
				registerHide();
				launch_toast("Invalid Mail id", false);
			}
			//else if (res == false) {
			//	document.getElementById("loginerror").innerHTML = "Invalid mailid or password";
			//}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/userlogin");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("mailid=" + mailid + "&password=" + password);
}

function logout() {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res == -1) {
				registerHide();
				launch_toast("Login before logout", false);
			}
			else if (res == true) {
				registerHide();
				launch_toast("Logout successfully", true);
				viewCategories();
			}
		}
	}

	xhr.open("POST", "http://localhost:8081/Snackieee/userlogout");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send();
}


function registerVisible() {
	document.getElementById("regerror").innerHTML = "";
	document.getElementById("registerModal").style.display = "block";
}

function registerHide() {
	document.getElementById("regusername").value = "";
	document.getElementById("regmailid").value = "";
	document.getElementById("regpassword1").value = "";
	document.getElementById("regpassword2").value = "";
	document.getElementById("registerModal").style.display = "none";
}

function loginvisible() {
	registerHide();
	document.getElementById("loginerror").innerHTML = "";
	document.getElementById("loginModal").style.display = "block";
}

function loginHide() {
	document.getElementById("loginmailid").value = "";
	document.getElementById("loginpassword").value = "";
	document.getElementById("loginModal").style.display = "none";
	registerHide();
}

function reviewvisible() {
	document.getElementById("reviewmodal").style.display = "block";
}

function reviewHide() {
	document.getElementById("snackreview").value = "";
	document.getElementById("reviewmodal").style.display = "none";
}

function showreviewvisible() {
	document.getElementById("showreviewmodal").style.display = "block";
}

function showreviewHide() {
	document.getElementById("showreviewmodal").style.display = "none";
}


function launch_toast(message, check) {

	if (check) {
		document.getElementById("img").innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-square-fill" viewBox="0 0 16 16">
  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm10.03 4.97a.75.75 0 0 1 .011 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.75.75 0 0 1 1.08-.022z"/>
</svg>`;
	} else {
		document.getElementById("img").innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-info-square-fill" viewBox="0 0 16 16">
  <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm8.93 4.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM8 5.5a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
</svg>`;
	}

	document.getElementById("desc").innerHTML = message;
	var x = document.getElementById("toast")
	x.className = "show";
	setTimeout(function() { x.className = x.className.replace("show", ""); }, 4000);
}

function addProduct() {

	var category_id = document.getElementById("category_id");
	var snack_name = document.getElementById("snack_name");
	var price = document.getElementById("price");
	var stock = document.getElementById("stock");
	var quantity = document.getElementById("quantity");
	var snack_image = document.getElementById("snack_image");

	if (category_id == "" || snack_name == "" || price == "" || stock == "" || quantity == "" || snack_image == "") {
		launch_toast("Please Fill the details", false);
		return;
	}
	if (stock <= 0) {
		launch_toast("Stock can't be less then 1", false);
		return;
	}
	if (price <= 0) {
		launch_toast("price cant be less then Rs.1", false);
		return;
	}

	let verify = quantity + "";

	if (verify.indexOf('.') != -1) {
		launch_toast("Quantity can't be in decimal", false);
		return;
	}

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res) {
				launch_toast("Snack Added Successfully", true);
			}
			category_id.innerHTML = "";
			snack_name.innerHTML = "";
			price.innerHTML = "";
			stock.innerHTML = "";
			quantity.innerHTML = "";
			snack_image.innerHTML = "";
		}
	}
	xhr.open("POST", "http://localhost:8081/Snackieee/addsnacks");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("category_id=" + category_id.value + "&snack_name=" + snack_name.value + "&price=" + price.value + "&stock=" + stock.value + "&quantity=" + quantity.value + "&snack_image=" + snack_image.value);
}