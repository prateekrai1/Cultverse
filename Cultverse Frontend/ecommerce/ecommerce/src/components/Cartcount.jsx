import React from 'react'

export default function Cartcount({number,position='absolute',color='red',top,right}) {
  return (
    <div style={{position:position,height:'20px',width:'20px',borderRadius:'50%',backgroundColor:color,display:'flex',justifyContent:'center',alignItems:'center',top:top,right:right}}>
      <span style={{color:'white',fontSize:'0.7rem'}}>{number}</span>
    </div>
  )
}
