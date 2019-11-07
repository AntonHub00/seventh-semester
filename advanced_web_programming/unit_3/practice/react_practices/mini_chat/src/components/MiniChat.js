import React from 'react';
import Button from './Button';
import TextBox from './TextBox';

export default class MiniChat extends React.Component {
    state = {
        emojies: [
            {
                content: 'A',
                id: 1
            },
            {
                content: 'B',
                id: 2

            },
            {
                content: 'C',
                id: 3

            }
        ],
        text_boxes: [],
        input_content: "",
    }

    render() {
        return (
            <div>
                <h1>MiniChat</h1>

                {this.state.emojies.map((emoji) => {
                    return (<Button key={emoji.id} emoji={emoji} add_emoji={this.add_emoji} />)
                })}

                <form onSubmit={this.add_text_box}>
                    <input type="text"
                        value={this.state.input_content}
                        onChange={this.store_input_value.bind(this)}
                    ></input>
                    <button type="submit" >Add</button>
                </form>

                {this.state.text_boxes.map((box) => {
                    return (<TextBox key={box.id} box={box} />)
                })}
            </div>
        );
    }

    store_input_value(e) {
        this.setState({ input_content: e.target.value });
    }

    add_emoji = (e) => {
        this.setState({
            input_content: this.state.input_content.concat(e.target.innerText)
        });
    }

    add_text_box = (e) => {
        e.preventDefault();

        this.setState({
            text_boxes: this.state.text_boxes.concat({
                id: Date.now(),
                content: this.state.input_content
            })
        });
    }
}
