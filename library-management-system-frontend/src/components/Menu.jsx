import React from 'react'
import styles from './Menu.module.css'
import { NavLink } from 'react-router-dom'

function Menu({isMenuOpen}) {
    

  return (
    <div className={styles.container}  >
        <div className={styles.menuBar} id='menuBar' onClick={(e)=>{
                if(e.target.id=== 'menuBar'){
                    isMenuOpen(false) 
                }
              }
        } >
                <ul className={styles.navigation}>
                    <li>
                        <div className={styles.logo}>
                            <img src="/src/assets/library.jpeg" alt="library" />
                            <img className={styles.cancle} src="/src/assets/cancleImg.jpeg" alt="cancle" onClick={()=>isMenuOpen(false)}/>
                        </div>  
                    </li>
                    <li>
                        <NavLink onClick={()=>isMenuOpen(false)} to='register'>Student Registration</NavLink>
                    </li>
                    <li>
                        <NavLink onClick={()=>isMenuOpen(false)} to='student'>Student Data</NavLink>
                    </li>
                    <li>
                        <NavLink onClick={()=>isMenuOpen(false)} to='addbook'>Add Book</NavLink>
                    </li>
                    <li>
                        <NavLink onClick={()=>isMenuOpen(false)} to='updatebook'>Update Book</NavLink>
                    </li>
                </ul>
        </div>
    </div>
  )
}

export default Menu
