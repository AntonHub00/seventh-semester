import React from 'react';

export default class TextBox extends React.Component {
    render() {
        return (
            <p>{this.props.box.content}</p>
        );
    }
}
