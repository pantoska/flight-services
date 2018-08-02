import React from 'react';
import { NavLink } from 'react-router-dom';

const Navigation = () => {
	return (
		<nav>
			<ul>
				<li><NavLink activeClassName='current' to='/'>Home</NavLink></li>
				<li><NavLink activeClassName='current' to='/flightAdd'>Add Flight</NavLink></li>
				<li><NavLink activeClassName='current' to='/flightDelete'>Delete Flight</NavLink></li>			
				<li><NavLink activeClassName='current' to='/flightStart'>Start Flight</NavLink></li>
				<li><NavLink activeClassName='current' to='/flightStop'>Stop Flight</NavLink></li>
			</ul>
		</nav>
		
	);
};

export default Navigation;	
