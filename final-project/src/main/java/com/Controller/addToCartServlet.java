package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.Cart;
import com.cart.CartDAO;
import com.item.Item;
import com.item.ItemDAO;
import com.tree.Tree;
import com.tree.TreeDAO;
import com.user.User;

@WebServlet("/addToCart")
public class addToCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/product.jsp";
		Integer itemId = null;
		Integer quantity = 1;
		String state = "order";
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) // check login
		{
			url = "/login.jsp";
		} else {

			url = "salingProduct";
			try {
				itemId = Integer.parseInt(req.getParameter("itemId"));
			} catch (NumberFormatException nfe) {

			}
			Tree tree = TreeDAO.selectTreeById(itemId);

			if (CartDAO.checkExistCart(user.getId())) {
				Cart cart = CartDAO.selectCartByUid(user.getId());
				if (ItemDAO.checkUnpaidItemById(cart.getId(), itemId)) {

				} else {
					Item item = new Item();
					item.setQuality(quantity);
					item.setPrice(tree.getPrice());
					item.setState(state);
					item.setTree(tree);
					cart.getItems().add(item);
					item.setCart(cart);
					ItemDAO.addItem(item);
				}
			} else {
				Cart cart = new Cart();
				Item item = new Item();
				cart.setUser(user);
				CartDAO.addCart(cart);
				item.setQuality(quantity);
				item.setPrice(tree.getPrice());
				item.setState(state);
				item.setTree(tree);
				cart.getItems().add(item);
				item.setCart(cart);
				ItemDAO.addItem(item);

			}

		}
		// req.getRequestDispatcher(url).forward(req, resp);
		resp.sendRedirect(req.getContextPath() + "/salingProduct");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
