import React, { useState, FormEvent } from 'react';

interface AppProps {}

const App: React.FC<AppProps> = () => {
    // State to manage the value of the input box
    const [inputValue, setInputValue] = useState<string>('');

    const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        try {
            const response = await fetch(`http://localhost:8080/15`);

            if (response.ok) {
                const res = await response.text();
                console.log('Request successful, result is ' + res);
            } else {
                console.error('Request failed');
            }
        } catch (error) {
            console.error('Error occurred:', error);
        }

        setInputValue('');
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label>
                    Input:
                    <input
                        type="text"
                        value={inputValue}
                        onChange={(e) => setInputValue(e.target.value)}
                    />
                </label>

                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default App;
