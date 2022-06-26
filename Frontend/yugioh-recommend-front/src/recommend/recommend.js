import React from "react";
import "rsuite/dist/rsuite.min.css";
import { InputNumber } from 'rsuite';

export default function Recommend(){

  const [numberOfDecks, setValueNumberDecks] = React.useState(0)
  const [chosenDifficulty, setValueDifficulty] = React.useState(0)
    
    
    return (
      <div id="main">
        <div id="input-number-decks">
          <InputNumber
              min={5}
              max={100}
              defaultValue={1}
              onChange={(value) => { setValueNumberDecks(value) }}
            />
          Number Of Decks Selected : {numberOfDecks}
        </div>
        <div id="input-difficulty">
          <InputNumber
              min={1}
              max={12}
              defaultValue={1}
              onChange={(value) => { setValueDifficulty(value) }}
            />
          Selected Difficulty : {chosenDifficulty}
        </div>
        
      </div>



   );


}