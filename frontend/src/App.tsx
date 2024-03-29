import React, {FormEvent, useState} from 'react';

interface AppProps {
}

const App: React.FC<AppProps> = () => {
    const [inputValue, setInputValue] = useState<string>('');
    const [outputValue, setOutputValue] = useState<string>('');

    const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        try {
            const response = await fetch(`http://localhost:8080/${inputValue}`);

            console.log(response)
            if (response.ok) {
                const res = await response.text();
                setOutputValue(res);
                console.log('Request successful, result is ' + res);
            } else {
                setOutputValue("input is not a valid number");
                console.error('Request failed ');
            }
        } catch (error) {
            console.error('Error occurred:', error);
        }
        setInputValue('');
    };

    return (
        <div>
            <h1>{outputValue}</h1>
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
