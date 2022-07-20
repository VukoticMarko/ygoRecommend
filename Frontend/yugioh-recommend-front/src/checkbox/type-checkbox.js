import React from "react";

export default function TypeCheckbox(addTypeElement){ 
  
  const [chosenTypes, setValueTypes] = React.useState(0) 
  const handleChangeType = () => {
    setValueTypes(!chosenTypes);
  };

  
    return (
      <div>
        <hr></hr>
        Choose Prefered Types <br></br>
        <input
            id="normal"
            type="checkbox"
            value="Aqua"
            checked={chosenTypes}
            onChange={addTypeElement()}
          
          />
          Aqua
          <input
            id="normal"
            type="checkbox"
            value="Beast"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Beast
          <input
            id="normal"
            type="checkbox"
            value="Beast_Warrior"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Beast_Warrior
          <input
            id="normal"
            type="checkbox"
            value="Cyberse"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Cyberse
          <input
            id="normal"
            type="checkbox"
            value="Dinosaur"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Dinosaur
          <input
            id="normal"
            type="checkbox"
            value="Divine_Beast"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Divine_Beast
          <input
            id="normal"
            type="checkbox"
            value="Dragon"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Dragon
          <input
            id="normal"
            type="checkbox"
            value="Fairy"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Fairy
          <input
            id="normal"
            type="checkbox"
            value="Fiend"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Fiend
          <input
            id="normal"
            type="checkbox"
            value="Fish"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Fish
          <input
            id="normal"
            type="checkbox"
            value="Insect"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Insect
          <input
            id="normal"
            type="checkbox"
            value="Machine"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Machine
          <input
            id="normal"
            type="checkbox"
            value="Plant"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Plant
          <input
            id="normal"
            type="checkbox"
            value="Psychic"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Psychic
          <input
            id="normal"
            type="checkbox"
            value="Pyro"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Pyro
          <input
            id="normal"
            type="checkbox"
            value="Reptile"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Reptile
          <input
            id="normal"
            type="checkbox"
            value="Rock"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Rock
          <input
            id="normal"
            type="checkbox"
            value="Sea_Serpent"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Sea_Serpent
          <input
            id="normal"
            type="checkbox"
            value="Spellcaster"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Spellcaster
          <input
            id="normal"
            type="checkbox"
            value="Thunder"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Thunder
          <input
            id="normal"
            type="checkbox"
            value="Warrior"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Warrior
          <input
            id="normal"
            type="checkbox"
            value="Winged_Beast"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Winged_Beast
          <input
            id="normal"
            type="checkbox"
            value="Wyrm"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Wyrm
          <input
            id="normal"
            type="checkbox"
            value="Zombie"
            checked={chosenTypes}
            onChange={handleChangeType}
          />
          Zombie
      </div>
     
    );
  
}