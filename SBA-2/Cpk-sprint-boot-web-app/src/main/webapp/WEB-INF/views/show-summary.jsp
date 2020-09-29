<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Summary</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	

	<div class="navbar bg-info text-white" style="margin: 10px;">Thank You For Shopping With Us!
		Your Order has been successfully placed with OrderID #${OrderID}</div>
	<div class="alert bg-light" style="margin: 10px;">
		<p class="font-weight-bold text-info" style="float: center;">
		<h5>ORDER SUMMARY</h5>
		</p>
		<Table class="table table-borderless">
			<tr>
				<td>
					<p class="font-weight-bold text-info">User Details</p>

					<div>
						<div>Name&nbsp;:&nbsp; ${username}</div>
						<div>
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-envelope" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
									d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2zm13 2.383l-4.758 2.855L15 11.114v-5.73zm-.034 6.878L9.271 8.82 8 9.583 6.728 8.82l-5.694 3.44A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.739zM1 11.114l4.758-2.876L1 5.383v5.73z" />
</svg>
							&nbsp;:&nbsp; ${email}
						</div>
						<div>
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-telephone" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
									d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z" />
</svg>
							&nbsp;:&nbsp;${contact}
						</div>
					</div>
				</td>
				<td>
					<p class="font-weight-bold text-info">Address Details</p>

					<div>Address : ${deliveryAddress}</div>
				</td>
			</tr>
		</Table>


		<p class="font-weight-bold text-info">Product Details</p>

		<table class="table table-sm">
			<tr>

				<th>Product ID</th>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Amount</th>


			</tr>
			<c:forEach items="${KitDetails}" var="kitDetail">
				<tr>

					<td>${kitDetail.productId}</td>
					<td>${kitDetail.productName}</td>
					<td>${kitDetail.quantity }</td>
					<td>${kitDetail.amount}</td>


				</tr>
			</c:forEach>
		</table>
		<hr />
		<p class="font-weight-bold text-info">TOTAL AMOUNT :
			${TotalAmount}</p>
		</br></br></br></br>
	</div>

	
</body>
</html>