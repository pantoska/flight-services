import React, { Component } from 'react';
import Repo from './Repo';

class Home extends Component {
	constructor(props) {
		super(props);
		this.repository = React.createRef();
	}


	render() {
		return (
			<div>
				<Repo ref={this.repository} />
			</div>
		);
	}
}

export default Home;