import './App.css'
import {BrowserRouter as Router,Routes,Route,Outlet} from 'react-router-dom'
import { Navigation } from './pages/Navigation'
import Books from './pages/Books'
import StudentRgistration from './components/StudentRgistration'
import React, { createContext, useState } from 'react'
import LoadingModel from './components/LoadingModel'

function App() {
  const[searchState,setSearchState] = useState(false);
  const[searchValue,setSearchValue] = useState('');
  const[search,setSearch] = useState(false)
  
  return (

    <div className='App' id ='app'onClick={(e)=>{
      (e.target.id!='search') && setSearchState(false)
    }}>
    <Router>
      <Routes>
        <Route path='/' element={<Navigation searchState = {searchState} setSearchState = {setSearchState}
                                             searchValue = {searchValue} setSearchValue = {setSearchValue} 
                                             setSearch = {setSearch}/>} >
             <Route path='/' element={ <Books searchValue={searchValue} search={search} setSearch={setSearch}/> } />
             <Route path='register' element={<StudentRgistration />} />
        </Route>
      </Routes>
    </Router>
    </div>
  )
}

export default App
