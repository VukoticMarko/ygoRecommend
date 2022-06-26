import React, { useState } from "react";
import "rsuite/dist/rsuite.min.css";
import { InputNumber } from 'rsuite';
import TypeCheckbox from "../checkbox/type-checkbox";
import SubTypeCheckBox from "../checkbox/sub-type-checkbox";
import ExtraDeckCheckbox from "../checkbox/extra-deck-checkbox";
import PlaystyleCheckbox from "../checkbox/playstyle-checkbox";
import { Button } from "react-bootstrap";
import RecommendService from "./recommendService";

export default function Recommend(){



  const [numberOfDecks, setValueNumberDecks] = React.useState(0)
  const [chosenDifficulty, setValueDifficulty] = React.useState(0)
  
  var chosenTypes = [];
  const handleChangeType = (value) => {
    console.log(value)
    chosenTypes.push(value)
  };
  var chosenSubTypes = [];
  const handleChangeSubType = (value) => {
    chosenSubTypes.push(value)
  };
  var chosenExtraDeckMechanics = []
  const handleChangeExtra = (value) => {
    chosenExtraDeckMechanics.push(value)
  };
  var chosenPlaystyles = []
  const handleChangePlaystyle = (value) => {
    chosenPlaystyles.push(value)
  };

  const [ArchetypeRequest, serAreq] = useState({
    chosenTypes: chosenTypes,
    chosenDifficulty: 1,
    chosenSubTypes: chosenSubTypes,
    chosenPlaystyles: chosenPlaystyles,
    chosenExtraDeckMechanics: chosenExtraDeckMechanics,
    numberOfDecks: 1
});

  var scoredList = []

  async function recommend() {
    const ArchetypeRequest = {
      chosenTypes: chosenTypes,
      chosenDifficulty: chosenDifficulty,
      chosenSubTypes: chosenSubTypes,
      chosenPlaystyles: chosenPlaystyles,
      chosenExtraDeckMechanics: chosenExtraDeckMechanics,
      numberOfDecks: numberOfDecks
    }
    if(ArchetypeRequest.numberOfDecks === 0){
      ArchetypeRequest.numberOfDecks = 1
    }
    if(ArchetypeRequest.chosenDifficulty === 0){
      ArchetypeRequest.chosenDifficulty = 1
    }
    console.log(ArchetypeRequest)
    scoredList = await RecommendService.recommend(ArchetypeRequest);
    
  }


  return (
      <div id="main">
        <form>
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

          <div id="checkboxes-type">
          <hr></hr>
          Choose Prefered Types <br></br>
          <input
              id="aqua"
              type="checkbox"
              value="Aqua"
              onChange={() => handleChangeType("Aqua")}
            
            />
            Aqua
            <input
              id="normal"
              type="checkbox"
              value="Beast"
              onChange={() => handleChangeType("Beast")}
            />
            Beast
            <input
              id="normal"
              type="checkbox"
              value="Beast_Warrior"
              onChange={() => handleChangeType("Beast_Warrior")}
            />
            Beast_Warrior
            <input
              id="normal"
              type="checkbox"
              value="Cyberse"
              onChange={() => handleChangeType("Cyberse")}
            />
            Cyberse
            <input
              id="normal"
              type="checkbox"
              value="Dinosaur"
              onChange={() => handleChangeType("Dinosaur")}
            />
            Dinosaur
            <input
              id="normal"
              type="checkbox"
              value="Divine_Beast"
              onChange={() => handleChangeType("Divine_Beast")}
            />
            Divine_Beast
            <input
              id="normal"
              type="checkbox"
              value="Dragon"
              onChange={() => handleChangeType("Dragon")}
            />
            Dragon
            <input
              id="normal"
              type="checkbox"
              value="Fairy"
              onChange={() => handleChangeType("Fairy")}
            />
            Fairy
            <input
              id="normal"
              type="checkbox"
              value="Fiend"
              onChange={() => handleChangeType("Fiend")}
            />
            Fiend
            <input
              id="normal"
              type="checkbox"
              value="Fish"
              onChange={() => handleChangeType("Fish")}
            />
            Fish
            <input
              id="normal"
              type="checkbox"
              value="Insect"
              onChange={() => handleChangeType("Insect")}
            />
            Insect
            <input
              id="normal"
              type="checkbox"
              value="Machine"
              onChange={() => handleChangeType("Machine")}
            />
            Machine
            <input
              id="normal"
              type="checkbox"
              value="Plant"
              onChange={() => handleChangeType("Plant")}
            />
            Plant
            <input
              id="normal"
              type="checkbox"
              value="Psychic"
              onChange={() => handleChangeType("Psychic")}
            />
            Psychic
            <input
              id="normal"
              type="checkbox"
              value="Pyro"
              onChange={() => handleChangeType("Pyro")}
            />
            Pyro
            <input
              id="normal"
              type="checkbox"
              value="Reptile"
              onChange={() => handleChangeType("Reptile")}
            />
            Reptile
            <input
              id="normal"
              type="checkbox"
              value="Rock"
              onChange={() => handleChangeType("Rock")}
            />
            Rock
            <input
              id="normal"
              type="checkbox"
              value="Sea_Serpent"
              onChange={() => handleChangeType("Sea_Serpent")}
            />
            Sea_Serpent
            <input
              id="normal"
              type="checkbox"
              value="Spellcaster"
              onChange={() => handleChangeType("Spellcaster")}
            />
            Spellcaster
            <input
              id="normal"
              type="checkbox"
              value="Thunder"
              onChange={() => handleChangeType("Thunder")}
            />
            Thunder
            <input
              id="normal"
              type="checkbox"
              value="Warrior"
              onChange={() => handleChangeType("Warrior")}
            />
            Warrior
            <input
              id="normal"
              type="checkbox"
              value="Winged_Beast"
              onChange={() => handleChangeType("Winged_Beast")}
            />
            Winged_Beast
            <input
              id="normal"
              type="checkbox"
              value="Wyrm"
              onChange={() => handleChangeType("Wrym")}
            />
            Wyrm
            <input
              id="normal"
              type="checkbox"
              value="Zombie"
              onChange={() => handleChangeType("Zombie")}
            />
            Zombie
          </div>
          <div id="checkboxes-subtype">
          <hr></hr>
          Choose Prefered Sub-Types <br></br>
          <input
              id="normal"
              type="checkbox"
              value="Normal"
              onChange={() => handleChangeSubType("Normal")}
            />
            Normal
            <input
              id="normal"
              type="checkbox"
              value="Effect"
              onChange={() => handleChangeSubType("Effect")}
            />
            Effect
            <input
              id="normal"
              type="checkbox"
              value="Fusion"
              onChange={() => handleChangeSubType("Fusion")}
            />
            Fusion
            <input
              id="normal"
              type="checkbox"
              value="Synchro"
              onChange={() => handleChangeSubType("Synchro")}
            />
            Synchro
            <input
              id="normal"
              type="checkbox"
              value="Pendulum"
              onChange={() => handleChangeSubType("Pendulum")}
            />
            Pendulum
            <input
              id="normal"
              type="checkbox"
              value="XYZ"
              onChange={() => handleChangeSubType("XYZ")}
            />
            XYZ
            <input
              id="normal"
              type="checkbox"
              value="Link"
              onChange={() => handleChangeSubType("Link")}
            />
            Link
            <input
              id="normal"
              type="checkbox"
              value="Token"
              onChange={() => handleChangeSubType("Token")}
            />
            Token
            <input
              id="normal"
              type="checkbox"
              value="Tuner"
              onChange={() => handleChangeSubType("Tuner")}
            />
            Tuner
            <input
              id="normal"
              type="checkbox"
              value="Ritual"
              onChange={() => handleChangeSubType("Ritual")}
            />
            Ritual
            <input
              id="normal"
              type="checkbox"
              value="Toon"
              onChange={() => handleChangeSubType("Toon")}
            />
            Toon
            <input
              id="normal"
              type="checkbox"
              value="Union"
              onChange={() => handleChangeSubType("Union")}
            />
            Union
            <input
              id="normal"
              type="checkbox"
              value="Spirit"
              onChange={() => handleChangeSubType("Spirit")}
            />
            Spirit
            <input
              id="normal"
              type="checkbox"
              value="Gemini"
              onChange={() => handleChangeSubType("Gemini")}
            />
            Gemini
            <input
              id="normal"
              type="checkbox"
              value="Flip"
              onChange={() => handleChangeSubType("Flip")}
            />
            Flip
          </div>
          <div id="checkboxes-extradeck">
          <hr></hr>
          Choose Prefered Extra-Deck Mechanics <br></br>
          <input
              id="normal"
              type="checkbox"
              value="Fusion"
              onChange={() => handleChangeExtra("Fusion")}
            />
            Fusion
            <input
              id="normal"
              type="checkbox"
              value="Synchro"
              onChange={() => handleChangeExtra("Synchro")}
            />
            Sybchro
            <input
              id="normal"
              type="checkbox"
              value="XYZ"
              onChange={() => handleChangeExtra("XYZ")}
            />
            XYZ
            <input
              id="normal"
              type="checkbox"
              value="Link"
              onChange={() => handleChangeExtra("Link")}
            />
            Link
            
          </div>
          <div id="checkboxes-subtype">
            <hr></hr>
          Choose Prefered Playstyle <br></br>
          <input
              id="normal"
              type="checkbox"
              value="Beatdown_Aggro"
              onChange={() => handleChangePlaystyle("Beatdown_Aggro")}
            />
            Beatdown_Aggro
            <input
              id="normal"
              type="checkbox"
              value="OTK"
              onChange={() => handleChangePlaystyle("OTK")}
            />
            OTK
            <input
              id="normal"
              type="checkbox"
              value="Control"
              onChange={() => handleChangePlaystyle("Control")}
            />
            Control
            <input
              id="normal"
              type="checkbox"
              value="Lock"
              onChange={() => handleChangePlaystyle("Lock")}
            />
            Lock
            <input
              id="normal"
              type="checkbox"
              value="Burn"
              onChange={() => handleChangePlaystyle("Burn")}
            />
            Burn
            <input
              id="normal"
              type="checkbox"
              value="Combo"
              onChange={() => handleChangePlaystyle("Combo")}
            />
            Combo
            <input
              id="normal"
              type="checkbox"
              value="Stun"
              onChange={() => handleChangePlaystyle("Stun")}
            />
            Stun
            <input
              id="normal"
              type="checkbox"
              value="Backrow_Defense"
              onChange={() => handleChangePlaystyle("Backrow_Defense")}
            />
            Backrow_Defense
            <input
              id="normal"
              type="checkbox"
              value="FTK"
              onChange={() => handleChangePlaystyle("FTK")}
            />
            FTK
            <input
              id="normal"
              type="checkbox"
              value="Mill"
              onChange={() => handleChangePlaystyle("Mill")}
            />
            Mill
            
          </div>
          <div id = "button">
            <br></br>
            <Button onClick={recommend}>GO!</Button>
          </div>
          <div>
            Recommendation: 
          </div>
        </form>
      </div>



   );


}