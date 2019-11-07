import React from 'react';

export default class Button extends React.Component {
    render() {
        return (
            <button onClick={this.props.add_emoji}>{this.props.emoji.content}</button>
        );
    }
}
